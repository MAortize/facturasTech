package  co.com.faturatech.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.com.faturatech.exception.*;
import co.com.faturatech.repository.*;
import co.com.faturatech.utility.Utilities;

import co.com.faturatech.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class PaymentTermsServiceImpl implements PaymentTermsService{

	@Autowired
	private PaymentTermsRepository paymentTermsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(PaymentTerms paymentTerms)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<PaymentTerms>> constraintViolations =validator.validate(paymentTerms);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return paymentTermsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<PaymentTerms> findAll(){
		log.debug("finding all PaymentTerms instances");
       	return paymentTermsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public PaymentTerms save(PaymentTerms entity) throws Exception {
		log.debug("saving PaymentTerms instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("PaymentTerms");
		}
		
		validate(entity);	
	
		if(paymentTermsRepository.existsById(entity.getPymtId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return paymentTermsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(PaymentTerms entity) throws Exception {
            	log.debug("deleting PaymentTerms instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("PaymentTerms");
	    		}
    	
                                if(entity.getPymtId()==null){
                    throw new ZMessManager().new EmptyFieldException("pymtId");
                    }
                        
            if(paymentTermsRepository.existsById(entity.getPymtId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getPymtId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            paymentTermsRepository.deleteById(entity.getPymtId());
            log.debug("delete PaymentTerms successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting PaymentTerms instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("pymtId");
            	}
            	if(paymentTermsRepository.existsById(id)){
           			delete(paymentTermsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public PaymentTerms update(PaymentTerms entity) throws Exception {

				log.debug("updating PaymentTerms instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("PaymentTerms");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(paymentTermsRepository.existsById(entity.getPymtId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return paymentTermsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<PaymentTerms> findById(Integer pymtId) {            
            	log.debug("getting PaymentTerms instance");
            	return paymentTermsRepository.findById(pymtId);
            }
			
}
