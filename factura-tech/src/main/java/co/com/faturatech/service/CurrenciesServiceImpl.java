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
import co.com.faturatech.service.facade.FacturaTechServiceFacade;
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
public class CurrenciesServiceImpl implements CurrenciesService{

	@Autowired
	private CurrenciesRepository currenciesRepository;
	
	@Autowired
	private Validator validator;
	@Autowired
	private FacturaTechServiceFacade facturaService;
                
    @Override        		
	public void validate(Currencies currencies)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Currencies>> constraintViolations =validator.validate(currencies);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){//request del servicio 
		try {
		//	responseDTO(response del servicio)= facturaService.getFactura(null, null, null, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	 	return currenciesRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Currencies> findAll(){
		log.debug("finding all Currencies instances");
       	return currenciesRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Currencies save(Currencies entity) throws Exception {
		log.debug("saving Currencies instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Currencies");
		}
		
		validate(entity);	
	
		if(currenciesRepository.existsById(entity.getCrrcId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return currenciesRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Currencies entity) throws Exception {
            	log.debug("deleting Currencies instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Currencies");
	    		}
    	
                                if(entity.getCrrcId()==null){
                    throw new ZMessManager().new EmptyFieldException("crrcId");
                    }
                        
            if(currenciesRepository.existsById(entity.getCrrcId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getCrrcId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            currenciesRepository.deleteById(entity.getCrrcId());
            log.debug("delete Currencies successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Currencies instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("crrcId");
            	}
            	if(currenciesRepository.existsById(id)){
           			delete(currenciesRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Currencies update(Currencies entity) throws Exception {

				log.debug("updating Currencies instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Currencies");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(currenciesRepository.existsById(entity.getCrrcId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return currenciesRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Currencies> findById(Integer crrcId) {            
            	log.debug("getting Currencies instance");
            	return currenciesRepository.findById(crrcId);
            }
			
}
