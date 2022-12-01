package shop.axon.orchestration.policy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.axon.orchestration.aggregate.*;
import shop.axon.orchestration.command.*;
import shop.axon.orchestration.event.*;

@Service
@ProcessingGroup("delivery_Policy")
public class PolicyHandler {

    @Autowired
    CommandGateway commandGateway;
}