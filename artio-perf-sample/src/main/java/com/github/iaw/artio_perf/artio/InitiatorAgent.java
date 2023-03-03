package com.github.iaw.artio_perf.artio;

import lombok.RequiredArgsConstructor;
import org.agrona.concurrent.Agent;
import uk.co.real_logic.artio.library.FixLibrary;
import uk.co.real_logic.artio.library.LibraryConfiguration;

@RequiredArgsConstructor
public class InitiatorAgent implements Agent {

    private final LibraryConfiguration configuration;

    @Override
    public int doWork() throws Exception {
        FixLibrary library = FixLibrary.connect(configuration);
        if (!library.isConnected()) {
            library.poll(1);
        }
        return 0;
    }

    @Override
    public String roleName() {
        return "initiator";
    }

    @Override
    public void onClose() {
    }
}
