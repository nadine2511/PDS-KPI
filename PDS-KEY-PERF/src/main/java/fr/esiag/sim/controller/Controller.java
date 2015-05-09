package fr.esiag.sim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.esiag.sim.dao.CityDAOImpl;
import fr.esiag.sim.dao.SectorDAOImpl;
import fr.esiag.sim.dao.OperatorDAOImpl;
import fr.esiag.sim.model.City;
import fr.esiag.sim.model.Sector;
import fr.esiag.sim.model.Operator;

@RestController
public class Controller {
	
	
	@RequestMapping(value = "/cityjson", method = RequestMethod.GET)
	public List<City> listJson() {
		CityDAOImpl cityDao = new CityDAOImpl();
		return cityDao.list();
	}
	@RequestMapping(value = "/sectorjson", method = RequestMethod.GET)
	public List<Sector> listJson2() {
		SectorDAOImpl sectorDao = new SectorDAOImpl();
		return sectorDao.list();
	}
	
	@RequestMapping(value = "/operatorjson", method = RequestMethod.GET)
	public List<Operator> listJson3() {
		OperatorDAOImpl operatorDao = new OperatorDAOImpl();
		return operatorDao.list();
	}	
}