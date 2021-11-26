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
public class CitiesServiceImpl implements CitiesService{

	@Autowired
	private CitiesRepository citiesRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Cities cities)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Cities>> constraintViolations =validator.validate(cities);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return citiesRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cities> findAll(){
		log.debug("finding all Cities instances");
       	return citiesRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Cities save(Cities entity) throws Exception {
		log.debug("saving Cities instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Cities");
		}
		
		validate(entity);	
	
		if(citiesRepository.existsById(entity.getCtsId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return citiesRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Cities entity) throws Exception {
            	log.debug("deleting Cities instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Cities");
	    		}
    	
                                if(entity.getCtsId()==null){
                    throw new ZMessManager().new EmptyFieldException("ctsId");
                    }
                        
            if(citiesRepository.existsById(entity.getCtsId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getCtsId()).ifPresent(entidad->{	            	
	                													List<Clients> clientses = entidad.getClientses();
	                    	                    if(Utilities.validationsList(clientses)==true){
                       	 	throw new ZMessManager().new DeletingException("clientses");
                        }
	                	            });
                       

           
            
            citiesRepository.deleteById(entity.getCtsId());
            log.debug("delete Cities successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Cities instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("ctsId");
            	}
            	if(citiesRepository.existsById(id)){
           			delete(citiesRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Cities update(Cities entity) throws Exception {

				log.debug("updating Cities instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Cities");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(citiesRepository.existsById(entity.getCtsId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return citiesRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Cities> findById(Integer ctsId) {            
            	log.debug("getting Cities instance");
            	return citiesRepository.findById(ctsId);
            }
			
}
