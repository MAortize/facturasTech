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
public class BillsServiceImpl implements BillsService{

	@Autowired
	private BillsRepository billsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Bills bills)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Bills>> constraintViolations =validator.validate(bills);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return billsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Bills> findAll(){
		log.debug("finding all Bills instances");
       	return billsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Bills save(Bills entity) throws Exception {
		log.debug("saving Bills instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Bills");
		}
		
		validate(entity);	
	
		if(billsRepository.existsById(entity.getBllId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return billsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Bills entity) throws Exception {
            	log.debug("deleting Bills instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Bills");
	    		}
    	
                                if(entity.getBllId()==null){
                    throw new ZMessManager().new EmptyFieldException("bllId");
                    }
                        
            if(billsRepository.existsById(entity.getBllId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getBllId()).ifPresent(entidad->{	            	
	                													List<BillDetails> billDetailses = entidad.getBillDetailses();
	                    	                    if(Utilities.validationsList(billDetailses)==true){
                       	 	throw new ZMessManager().new DeletingException("billDetailses");
                        }
	                	            });
                       

           
            
            billsRepository.deleteById(entity.getBllId());
            log.debug("delete Bills successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Bills instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("bllId");
            	}
            	if(billsRepository.existsById(id)){
           			delete(billsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Bills update(Bills entity) throws Exception {

				log.debug("updating Bills instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Bills");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(billsRepository.existsById(entity.getBllId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return billsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Bills> findById(Integer bllId) {            
            	log.debug("getting Bills instance");
            	return billsRepository.findById(bllId);
            }
			
}
