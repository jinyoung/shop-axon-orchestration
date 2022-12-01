package shop.axon.orchestration.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.eventhandling.DisallowReplay;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.gateway.CommandGateway;

import shop.axon.orchestration.command.*;
import shop.axon.orchestration.event.*;
import shop.axon.orchestration.aggregate.*;


@Service
@ProcessingGroup("delivery")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;


}
