package org.nextrtc.examples.videochat_with_rest.domain.handler;

import org.nextrtc.examples.videochat_with_rest.repo.MemberRepository;
import org.nextrtc.signalingserver.api.NextRTCEvent;
import org.nextrtc.signalingserver.api.NextRTCEvents;
import org.nextrtc.signalingserver.api.NextRTCHandler;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NextRTCEventListener(NextRTCEvents.SESSION_CLOSED)
public class SessionClosedHandler implements NextRTCHandler {

    @Autowired
    private MemberRepository repo;

    @Override
    public void handleEvent(NextRTCEvent event) {
        event.getSessionId().ifPresent(id -> {
            repo.findByRtcId(id).ifPresent(member -> {
                member.markEnd();
            });
        });
    }

}
