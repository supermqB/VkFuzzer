package tool.fsm.vulkan.initializers;

import org.statefulj.fsm.model.State;
import org.statefulj.fsm.model.impl.StateImpl;
import org.statefulj.persistence.memory.MemoryPersisterImpl;
import tool.fsm.ExitCondition;
import tool.fsm.vulkan.VulkanEntity;
import tool.fsm.vulkan.actions.GenerateCodeAction;
import tool.fsm.vulkan.events.VulkanEvent;
import tool.fsm.vulkan.states.VulkanState;
import tool.fsm.vulkan.transitions.SimpleTransition;
import tool.fsm.vulkan.transitions.TransitionType;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * Created by constantinos on 30/03/2016.
 * Initializes states
 */
public class StatesInitializer {
    private final ExitCondition exitCondition;
    private Map<VulkanState, State<VulkanEntity>> states;
    private MemoryPersisterImpl<VulkanEntity> persister;
    private GenerateCodeAction<VulkanEntity> generateCodeAction;

    public StatesInitializer(final ExitCondition exitCondition) {
        states = new HashMap<>();
        generateCodeAction = new GenerateCodeAction<>(exitCondition);
        this.exitCondition = exitCondition;
    }

    public StatesInitializer(final ExitCondition exitCondition,
                             final Map<VulkanState, State<VulkanEntity>> states) {
        this.states = states;
        generateCodeAction = new GenerateCodeAction<>(exitCondition);
        this.exitCondition = exitCondition;
    }

    public MemoryPersisterImpl<VulkanEntity> getPersister() {
        return persister;
    }

    // Initializes states
    public void initializeStates() {
        createStates();

        // Start of sequential  part of the fsm
        defineTransition(TransitionType.SEQUENTIAL,
                VulkanState.START,
                VulkanState.VK_ENUMERATE_INSTANCE_EXTENSION_PROPERTIES);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_ENUMERATE_INSTANCE_EXTENSION_PROPERTIES,
                VulkanState.VK_ENUMERATE_INSTANCE_LAYER_PROPERTIES);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_ENUMERATE_INSTANCE_LAYER_PROPERTIES,
                VulkanState.VK_APPLICATION_INFO);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_APPLICATION_INFO,
                VulkanState.VK_INSTANCE_CREATE_INFO);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_INSTANCE_CREATE_INFO,
                VulkanState.VK_CREATE_INSTANCE);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_INSTANCE,
                VulkanState.VK_ENUMERATE_PHYSICAL_DEVICES);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_ENUMERATE_PHYSICAL_DEVICES,
                VulkanState.GET_DEVICE_PROPERTIES);

        defineTransition(TransitionType.REPEATING,
                VulkanState.GET_DEVICE_PROPERTIES,
                VulkanState.VK_CREATE_DEVICE);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_DEVICE,
                VulkanState.VK_CREATE_COMMAND_POOL);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_COMMAND_POOL,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS);

        // Define random transitions from the VK_ALLOCATE_COMMAND_BUFFERS state
        VulkanState[] randomStates =
        {
                VulkanState.VK_CREATE_SEMAPHORE,
                VulkanState.VK_CREATE_EVENT,
                VulkanState.VK_CREATE_FENCE,
                VulkanState.VK_GET_DEVICE_QUEUE,
                VulkanState.DEALLOCATION
        };

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS,
                randomStates);
        // End of sequential part

        // Entering random path
        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_GET_DEVICE_QUEUE,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_EVENT,
                VulkanState.VK_GET_EVENT_STATUS);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_GET_EVENT_STATUS,
                VulkanState.VK_RESET_EVENT);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_RESET_EVENT,
                VulkanState.VK_SET_EVENT);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_SET_EVENT,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_FENCE,
                VulkanState.VK_GET_FENCE_STATUS);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_GET_FENCE_STATUS,
                VulkanState.VK_RESET_FENCES);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_RESET_FENCES,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS);

        defineTransition(TransitionType.REPEATING,
                VulkanState.VK_CREATE_SEMAPHORE,
                VulkanState.VK_ALLOCATE_COMMAND_BUFFERS);

        defineTransition(TransitionType.SEQUENTIAL,
                VulkanState.DEALLOCATION,
                VulkanState.STOP);

        LinkedList<State<VulkanEntity>> fsmStates =
                new LinkedList<>(states.values());

        persister = new MemoryPersisterImpl<>(fsmStates,
                states.get(VulkanState.START));
    }

    // Creates and initializes the states
    private void createStates() {
        VulkanState vulkanStates[] = VulkanState.values();

        // Initialize everything except last state
        for (int i = 0; i < vulkanStates.length - 1; ++i) {
            VulkanState state = vulkanStates[i];
            states.put(state, new StateImpl<>(state.toString()));
        }

        // Add STOP state
        VulkanState stopState = vulkanStates[vulkanStates.length - 1];
        states.put(stopState, new StateImpl<>(stopState.toString(), true));
    }

    // Defines a transition between two states
    private void defineTransition(TransitionType transitionType,
                                  VulkanState state,
                                  VulkanState... nextState) {
        String event = VulkanEvent.GENERATE_PROGRAM.toString();
        State<VulkanEntity> fsmState = states.get(state);

        ArrayList<State<VulkanEntity>> nextStates = new ArrayList<>();
        for (VulkanState tmpVulkanState : nextState) {
            nextStates.add(states.get(tmpVulkanState));
        }

        switch (transitionType) {
            case REPEATING:
                fsmState.addTransition(event,
                        new SimpleTransition<>(
                                generateCodeAction,
                                fsmState,
                                nextStates));
                break;
            case SEQUENTIAL:
                fsmState.addTransition(event, nextStates.get(0), generateCodeAction);
        }
    }
}
