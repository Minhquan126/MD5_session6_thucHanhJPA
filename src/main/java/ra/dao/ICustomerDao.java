package ra.dao;

import ra.model.Customer;

import java.util.List;

public interface ICustomerDao {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
}
