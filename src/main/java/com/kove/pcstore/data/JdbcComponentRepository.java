package com.kove.pcstore.data;

import com.kove.pcstore.model.Component;
import com.kove.pcstore.model.Manafacturer;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcComponentRepository implements ComponentRepository {
    private static final String TABLE_NAME = "component";
    private static final String GENERATED_KEY_COLUMN = "id";

    private static final String SELECT_ALL = "SELECT id, title, manafacturer, description, type, created_at FROM component";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcComponentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.jdbcInsert = new SimpleJdbcInsert(jdbc)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<Component> findAll() {
        return Set.copyOf(jdbc.query(SELECT_ALL, this::mapRowToComponent));
    }



    @Override
    public Optional<Component> save(Component component) {
        try {
            component.setId(saveComponentDetails(component));
            return Optional.of(component);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }


    private Component mapRowToComponent(ResultSet rs, int rowNum) throws SQLException {
        return new Component(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("manafacturer"),
                Component.Type.valueOf(rs.getString("type")),
                rs.getDate("created_at")

                );
    }

        private long saveComponentDetails(Component component) {
        Map<String, Object> values = new HashMap<>();

        values.put("title", component.getTitle());
        values.put("description", component.getDescription());
        values.put("manafacturer", component.getManafacturer());
        values.put("type", component.getType());
        values.put("created_at", component.getCreatedAt());

        return jdbcInsert.executeAndReturnKey(values).longValue();
    }
}
