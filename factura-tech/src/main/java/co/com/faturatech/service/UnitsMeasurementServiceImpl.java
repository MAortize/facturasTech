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
public class UnitsMeasurementServiceImpl implements UnitsMeasurementService{

	@Autowired
	private UnitsMeasurementRepository unitsMeasurementRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(UnitsMeasurement unitsMeasurement)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<UnitsMeasurement>> constraintViolations =validator.validate(unitsMeasurement);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return unitsMeasurementRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<UnitsMeasurement> findAll(){
		log.debug("finding all UnitsMeasurement instances");
       	return unitsMeasurementRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public UnitsMeasurement save(UnitsMeasurement entity) throws Exception {
		log.debug("saving UnitsMeasurement instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("UnitsMeasurement");
		}
		
		validate(entity);	
	
		if(unitsMeasurementRepository.existsById(entity.getUntmId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return unitsMeasurementRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(UnitsMeasurement entity) throws Exception {
            	log.debug("deleting UnitsMeasurement instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("UnitsMeasurement");
	    		}
    	
                                if(entity.getUntmId()==null){
                    throw new ZMessManager().new EmptyFieldException("untmId");
                    }
                        
            if(unitsMeasurementRepository.existsById(entity.getUntmId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getUntmId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                													List<Concepts> conceptses = entidad.getConceptses();
	                    	                    if(Utilities.validationsList(conceptses)==true){
                       	 	throw new ZMessManager().new DeletingException("conceptses");
                        }
	                	            });
                       

           
            
            unitsMeasurementRepository.deleteById(entity.getUntmId());
            log.debug("delete UnitsMeasurement successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting UnitsMeasurement instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("untmId");
            	}
            	if(unitsMeasurementRepository.existsById(id)){
           			delete(unitsMeasurementRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public UnitsMeasurement update(UnitsMeasurement entity) throws Exception {

				log.debug("updating UnitsMeasurement instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("UnitsMeasurement");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(unitsMeasurementRepository.existsById(entity.getUntmId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return unitsMeasurementRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<UnitsMeasurement> findById(Integer untmId) {            
            	log.debug("getting UnitsMeasurement instance");
            	return unitsMeasurementRepository.findById(untmId);
            }
			
}
