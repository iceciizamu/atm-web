package th.ac.ku.atm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.atm.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

/* @Repository
public class CustomerRepository {

    private JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        String query = "SELECT * FROM customer";
        List<Customer> customers =
                jdbcTemplate.query(query, new CustomerMapper());
        return customers;

    }

    public Customer findById(int id) {
        String query = "SELECT * FROM customer WHERE id = " + id;
        Customer customer =
                jdbcTemplate.queryForObject(query, new CustomerMapper());
        return customer;
    }

    public void save(Customer customer) {
        String query = "INSERT INTO customer (id,name,pin) VALUES (?,?,?);";
        Object[] data = new Object[]
                { customer.getId(), customer.getName(), customer.getPin() };
        jdbcTemplate.update(query, data);
    }

    public void deleteById(int id) {
        String query = "DELETE FROM customer WHERE id = " + id;
        jdbcTemplate.update(query);

    }
    class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pin = resultSet.getString("pin");

            return new Customer(id,name,pin);

        }
    }

}*/


