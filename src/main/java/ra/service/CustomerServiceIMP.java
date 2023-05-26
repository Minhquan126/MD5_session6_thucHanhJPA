package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.ICustomerDao;
import ra.model.Customer;

import java.util.List;
@Service
public class CustomerServiceIMP implements ICustomerService{
    @Autowired
    private ICustomerDao iCustomerDao;
    @Override
    public List<Customer> findAll() {
        return iCustomerDao.findAll();
    }

    @Override
    public void save(Customer customer) {
iCustomerDao.save(customer);
    }

    @Override
    public void delete(Long id) {
iCustomerDao.delete(id);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerDao.findById(id);
    }
}
