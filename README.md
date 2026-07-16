# DaemonOS

> "A terminal-first operating environment built in Java."

DaemonOS is a personal project that aims to create an operating system-like environment entirely inside the terminal. Instead of focusing on graphical interfaces, DaemonOS emphasizes speed, simplicity, and a unique terminal experience.

> **Current Status:** v0.1-alpha

---

## About

DaemonOS is not intended to replace an actual operating system.

It is a learning project designed to explore:

- Java
- Terminal User Interfaces (TUI)
- Operating System concepts
- Authentication systems
- File systems
- Shell design
- Process management
- Software architecture

The goal is to gradually build a complete terminal environment from scratch.

---

## Features

### v0.1-alpha

- [ ] Custom DaemonOS boot screen
- [x] User account creation
- [x] Username & password login
- [x] Password masking
- [x] Terminal-first interface
- [x] Custom input/output style (`<<` and `>>`)
- [ ] Modular Java project structure

---

## Planned Roadmap

### v0.2
- Persistent user storage
- Hidden `.daemonos/.system` directory
- Password hashing
- Secure authentication

### v0.3
- DaemonOS Shell
- Built-in commands
- Multiple user support
- Configuration system

### v0.4
- Virtual file system
- Directories & files
- File permissions
- User home directories

### v0.5
- Process manager
- Background tasks
- System logs

### Future Goals

- Plugin system
- Package manager
- Networking
- Scripting language
- Custom terminal themes
- Complete TUI desktop experience

---

## Project Structure

```
DaemonOS/
│
├── src/
├── resources/
├── test/
├── pom.xml
├── README.md
└── .daemonos/
    └── .system/
        ├── users/
        ├── config/
        └── logs/
```

---

## Technologies

- Java
- Maven
- Lanterna (planned)
- Java Cryptography API
- File I/O
- Collections Framework

---

## Philosophy

DaemonOS follows one simple principle:

> **Build everything yourself to understand how it works.**

Rather than relying on existing frameworks for every feature, this project focuses on learning by implementing the underlying systems.

---

## Current Version

```
DaemonOS v0.1-alpha
```

Status:

- [ ] Boot System 
- [ ] Login System 
- [ ] Account Creation 
- [ ] User Storage 
- [ ] Shell 
- [ ] File System 

---

## Building

Clone the repository

```bash
git clone https://github.com/<your-username>/DaemonOS.git
```

Build

```bash
mvn clean package
```

Run

```bash
mvn exec:java
```

---

## Screenshots

*(Coming Soon)*

---

## Why "DaemonOS"?

The name comes from the concept of **daemons**—background processes commonly found in Unix-like operating systems.

DaemonOS is inspired by low-level system design and aims to recreate many operating system concepts inside a Java terminal application.

---
