# Echo Server

A simple **multi-threaded TCP Echo Server** built in Java. You can connect to it using **Telnet** or any TCP client and see your messages echoed back in real-time.  

---

## Features

- Multi-threaded server handling multiple clients concurrently.
- Supports **custom ports** via CLI arguments (`-p` or `--port`). Default is `8080`.
- Lightweight and easy to use for testing TCP connections.

---

## Quick Start

Follow these steps to clone, build, and run the server. All commands are included in **one code block**:

```bash
# Clone the repository
git clone https://github.com/SahilsDevelopment/echo-server.git
cd echo-server

# Build the project
./gradlew clean build

# Run the server on port 9090 (or change the port as needed)
java -jar build/libs/TCP_Server-1.0-SNAPSHOT.jar -p 9090

# In a new terminal, connect using telnet
telnet localhost 9090

# Type any message (e.g., "hello") and press Enter
# You will see it echoed back:
# Echo: hello
