package es.upsa.dasi.cochesjee.infrastructure.persistance.dao.impl;

import es.upsa.dasi.cochesjee.domain.model.Coche;
import es.upsa.dasi.common.domain.exceptions.CochesRunTimeException;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.Dao;
import es.upsa.dasi.cochesjee.infrastructure.persistance.dao.dtos.CocheRow;
import es.upsa.dasi.common.domain.exceptions.NotFoundCochesException;
import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;

import javax.sql.DataSource;
import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@DataSourceDefinition(
        name = "jdbc/coches",
        className = "org.postgresql.ds.PGSimpleDataSource",
        url = "jdbc:postgresql://localhost:5432/upsa",
        user = "system",
        password = "manager",
        initialPoolSize = 1,
        maxPoolSize = 3,
        minPoolSize = 1
)

@ApplicationScoped
public class DaoImpl implements Dao {

    @Resource(name = "jdbc/coches")
    DataSource dataSource;

    @Override
    public List<CocheRow> findAllCoches() {

        final String SQL = """
                           SELECT c.id, c.marca, c.modelo, c.anio_lanzamiento, c.caballos, c.pagina_web
                           FROM coches c
                           ORDER BY c.caballos DESC
                           """;
        List<CocheRow> coches = new ArrayList<>();

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ){

            try(ResultSet resultSet = preparedStatement.executeQuery()){

                while(resultSet.next()){

                    CocheRow coche = CocheRow.builder()
                            .id(resultSet.getLong(1))
                            .marca(resultSet.getString(2))
                            .modelo(resultSet.getString(3))
                            .anioLanzamiento(resultSet.getString(4))
                            .caballos(resultSet.getInt(5))
                            .paginaWeb(resultSet.getString(6))
                            .build();
                    coches.add(coche);
                }
            }
            return coches;
        }catch (SQLException sqlException){
            throw new CochesRunTimeException(sqlException.getMessage(), sqlException);
        }

    }

    @Override
    public Optional<CocheRow> findCocheById(long id) {

        final String SQL = """
                           SELECT c.id, c.marca, c.modelo, c.anio_lanzamiento, c.caballos, c.pagina_web
                           FROM coches c
                           WHERE c.id = ?
                           """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ){
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(!resultSet.next()) return Optional.empty();
                return Optional.of(CocheRow.builder()
                        .id(resultSet.getLong(1))
                        .marca(resultSet.getString(2))
                        .modelo(resultSet.getString(3))
                        .anioLanzamiento(resultSet.getString(4))
                        .caballos(resultSet.getInt(5))
                        .paginaWeb(resultSet.getString(6))
                        .build());
            }
        }catch (SQLException sqlException){
            throw new CochesRunTimeException(sqlException.getMessage(), sqlException);
        }

    }

    @Override
    public CocheRow insertCoche(CocheRow coche) {

        final String SQL = """
                           INSERT INTO coches(marca, modelo, anio_lanzamiento, caballos, pagina_web)
                                        VALUES(?,      ?,         ?,              ?,         ?)
                           """;
        final String[] GENERATED_KEYS = { "id" };

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL, GENERATED_KEYS);
                ){
            preparedStatement.setString(1, coche.getMarca());
            preparedStatement.setString(2, coche.getModelo());
            preparedStatement.setString(3, coche.getAnioLanzamiento());
            preparedStatement.setInt(4, coche.getCaballos());
            preparedStatement.setString(5, coche.getPaginaWeb());
            preparedStatement.executeUpdate();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                resultSet.next();
                return coche.withId(resultSet.getLong(1));
            }
        }catch (SQLException sqlException){
            throw new CochesRunTimeException(sqlException.getMessage(), sqlException);
        }

    }

    @Override
    public void updateCoche(CocheRow coche) throws NotFoundCochesException {

        final String SQL = """
                           UPDATE coches
                           SET marca = ?, modelo = ?, anio_lanzamiento = ?, caballos = ?, pagina_web = ?
                           WHERE id = ?
                           """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ){
            preparedStatement.setString(1, coche.getMarca());
            preparedStatement.setString(2, coche.getModelo());
            preparedStatement.setString(3, coche.getAnioLanzamiento());
            preparedStatement.setInt(4, coche.getCaballos());
            preparedStatement.setString(5, coche.getPaginaWeb());
            preparedStatement.setLong(6, coche.getId());
            int i = preparedStatement.executeUpdate();
            if (i==0) throw new  NotFoundCochesException("No se ha encontrado el coche con el id: " + coche.getId());


        }catch (SQLException sqlException){
            throw new CochesRunTimeException(sqlException.getMessage(), sqlException);
        }

    }

    @Override
    public void deleteCoche(long id) throws NotFoundCochesException {
        final String SQL = """
                           DELETE FROM coches
                           WHERE id = ?
                           """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ){
            preparedStatement.setLong(1,id);
            int i = preparedStatement.executeUpdate();
            if (i==0) throw new NotFoundCochesException("No se ha encontrado el coche.");
        }catch (SQLException sqlException){
            throw new CochesRunTimeException(sqlException.getMessage(), sqlException);
        }
    }
}
