package org.project.openbaton.vnfm.generic;


import org.project.openbaton.catalogue.mano.common.Event;
import org.project.openbaton.catalogue.mano.record.VNFRecordDependency;
import org.project.openbaton.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.project.openbaton.catalogue.nfvo.ConfigurationParameter;
import org.project.openbaton.catalogue.nfvo.CoreMessage;
import org.project.openbaton.catalogue.nfvo.DependencyParameters;
import org.project.openbaton.common.vnfm_sdk.jms.AbstractVnfmSpringJMS;
import org.project.openbaton.common.vnfm_sdk.utils.VnfmUtils;
import org.project.openbaton.vnfm.generic.utils.EmsRegistrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.util.Map;

/**
 * Created by mob on 16.07.15.
 */
public class GenericVNFM extends AbstractVnfmSpringJMS {

    @Autowired
    private EmsRegistrator emsRegistrator;

    public static void main(String[] args) {
        SpringApplication.run(GenericVNFM.class);
    }

    @Override
    public VirtualNetworkFunctionRecord instantiate(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, Object scripts) throws Exception {

        log.info("Instantiation of VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord.getName());

        vnfmHelper.saveScriptOnEms(virtualNetworkFunctionRecord, scripts);

        log.info("Executed script: " + vnfmHelper.executeScriptsForEvent(virtualNetworkFunctionRecord, Event.INSTANTIATE, getMap(virtualNetworkFunctionRecord)));

        log.debug("added parameter to config");
        log.debug("CONFIGURATION: " + virtualNetworkFunctionRecord.getConfigurations());
        ConfigurationParameter cp = new ConfigurationParameter();
        cp.setConfKey("new_key");
        cp.setValue("new_value");
        virtualNetworkFunctionRecord.getConfigurations().getConfigurationParameters().add(cp);
        return virtualNetworkFunctionRecord;
    }

    @Override
    public void query() {

    }

    @Override
    public void scale() {

    }

    @Override
    public void checkInstantiationFeasibility() {

    }

    @Override
    public void heal() {

    }

    @Override
    public void updateSoftware() {
    }

    @Override
    public void upgradeSoftware() {
    }

    @Override
    public VirtualNetworkFunctionRecord modify(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, VNFRecordDependency dependency) throws Exception {
        log.debug("VirtualNetworkFunctionRecord VERSION is: " + virtualNetworkFunctionRecord.getHb_version());
        log.debug("VirtualNetworkFunctionRecord NAME is: " + virtualNetworkFunctionRecord.getName());
        log.debug("Got dependency: " + dependency);
        log.debug("Parameters are: ");
        for (Map.Entry<String, DependencyParameters> entry : dependency.getParameters().entrySet()) {
            log.debug("Source type: " + entry.getKey());
            log.debug("Parameters: " + entry.getValue().getParameters());
        }

        log.debug("LifeCycle events: " + VnfmUtils.getLifecycleEvent(virtualNetworkFunctionRecord.getLifecycle_event(), Event.CONFIGURE).getLifecycle_events() );

        log.info("-----------------------------------------------------------------------");
        log.info("Result script: \t" + vnfmHelper.executeScriptsForEvent(virtualNetworkFunctionRecord, Event.CONFIGURE, dependency));
        log.info("-----------------------------------------------------------------------");

        return virtualNetworkFunctionRecord;
    }

    @Override
    public VirtualNetworkFunctionRecord terminate(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        //TODO implemenet termination
        return virtualNetworkFunctionRecord;
    }

    @Override
    public CoreMessage handleError(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return null;
    }

    @Override
    protected void fillSpecificProvides(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        for (ConfigurationParameter configurationParameter : virtualNetworkFunctionRecord.getProvides().getConfigurationParameters()) {
            if (!configurationParameter.getConfKey().startsWith("#nfvo:")) {
                configurationParameter.setValue("" + ((int) (Math.random() * 100)));
                log.debug("Setting: " + configurationParameter.getConfKey() + " with value: " + configurationParameter.getValue());
            }
        }
    }

    @Override
    protected VirtualNetworkFunctionRecord start(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) throws Exception {

        log.debug("Starting vnfr: " + virtualNetworkFunctionRecord.getName());
        return virtualNetworkFunctionRecord;
    }

    @Override
    protected VirtualNetworkFunctionRecord configure(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) throws Exception {
        return virtualNetworkFunctionRecord;
    }

    @Override
    public void NotifyChange() {

    }

    @Override
    protected void checkEmsStarted(String hostname) {
        if (!emsRegistrator.getHostnames().contains(hostname))
            throw new RuntimeException("no ems for hostame: " + hostname);
    }
}
