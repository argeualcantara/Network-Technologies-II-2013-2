package controller;

import gui.model.SNMPModel;

import java.io.IOException;
import java.util.Date;

import core.util.ManagerUtil;


public class SNMPController {

	public SNMPModel getMessage(String ipAddress) {
		ManagerUtil manager = new ManagerUtil("udp:"+ipAddress+"/161");
		try {
			manager.listenPort();
			SNMPModel retorno = manager.getSNMPModel();
			ManagerUtil.manager.getSnmp().close();
			retorno.setIpAddress(ipAddress);
			return retorno;
		} catch (IOException e) {
			e.printStackTrace();
		}
		String newTimeString = new Date().toString();
		SNMPModel model = new SNMPModel(); //SMNPMAnager.getSMNPModel(ipAddress);
		model.setIpAddress(ipAddress);
		model.setSysUpTime(newTimeString);
		return model;
	}
}
