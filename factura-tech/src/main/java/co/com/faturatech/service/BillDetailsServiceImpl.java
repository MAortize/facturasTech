package co.com.faturatech.service;

import co.com.faturatech.domain.*;
import co.com.faturatech.exception.*;
import co.com.faturatech.repository.*;
import co.com.faturatech.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class BillDetailsServiceImpl implements BillDetailsService {
    @Autowired
    private BillDetailsRepository billDetailsRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(BillDetails billDetails)
        throws ConstraintViolationException {
        Set<ConstraintViolation<BillDetails>> constraintViolations = validator.validate(billDetails);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return billDetailsRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillDetails> findAll() {
        log.debug("finding all BillDetails instances");

        return billDetailsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BillDetails save(BillDetails entity) throws Exception {
        log.debug("saving BillDetails instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("BillDetails");
        }

        validate(entity);

        if (billDetailsRepository.existsById(entity.getBlldId())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return billDetailsRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(BillDetails entity) throws Exception {
        log.debug("deleting BillDetails instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("BillDetails");
        }

        if (entity.getBlldId() == null) {
            throw new ZMessManager().new EmptyFieldException("blldId");
        }

        if (billDetailsRepository.existsById(entity.getBlldId()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        billDetailsRepository.deleteById(entity.getBlldId());
        log.debug("delete BillDetails successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting BillDetails instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("blldId");
        }

        if (billDetailsRepository.existsById(id)) {
            delete(billDetailsRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public BillDetails update(BillDetails entity) throws Exception {
        log.debug("updating BillDetails instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("BillDetails");
        }

        validate(entity);

        if (billDetailsRepository.existsById(entity.getBlldId()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return billDetailsRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BillDetails> findById(Integer blldId) {
        log.debug("getting BillDetails instance");

        return billDetailsRepository.findById(blldId);
    }
}
