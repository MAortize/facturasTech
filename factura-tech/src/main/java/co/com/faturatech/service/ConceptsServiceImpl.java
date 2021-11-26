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
public class ConceptsServiceImpl implements ConceptsService{

	@Autowired
	private ConceptsRepository conceptsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Concepts concepts)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Concepts>> constraintViolations =validator.validate(concepts);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return conceptsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Concepts> findAll(){
		log.debug("finding all Concepts instances");
       	return conceptsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Concepts save(Concepts entity) throws Exception {
		log.debug("saving Concepts instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Concepts");
		}
		
		validate(entity);	
	
		if(conceptsRepository.existsById(entity.getCncId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return conceptsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Concepts entity) throws Exception {
            	log.debug("deleting Concepts instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Concepts");
	    		}
    	
                                if(entity.getCncId()==null){
                    throw new ZMessManager().new EmptyFieldException("cncId");
                    }
                        
            if(conceptsRepository.existsById(entity.getCncId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getCncId()).ifPresent(entidad->{	            	
	                													List<BillDetails> billDetailses = entidad.getBillDetailses();
	                    	                    if(Utilities.validationsList(billDetailses)==true){
                       	 	throw new ZMessManager().new DeletingException("billDetailses");
                        }
	                	            });
                       

           
            
            conceptsRepository.deleteById(entity.getCncId());
            log.debug("delete Concepts successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Concepts instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("cncId");
            	}
            	if(conceptsRepository.existsById(id)){
           			delete(conceptsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Concepts update(Concepts entity) throws Exception {

				log.debug("updating Concepts instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Concepts");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(conceptsRepository.existsById(entity.getCncId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return conceptsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Concepts> findById(Integer cncId) {            
            	log.debug("getting Concepts instance");
            	return conceptsRepository.findById(cncId);
            }
			
}
