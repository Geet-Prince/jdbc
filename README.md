# JDBC Learning in Java

My personal space for learning **JDBC (Java Database Connectivity)** with Java, Eclipse, and MySQL.

> I'm learning right now — this repo is just to track my progress, nothing fancy.

## What's inside

- `firstJDBC_App/` — my first JDBC program in Eclipse
  - `src/me/geetprince/jdbc/LaunchApp1.java` — connects to MySQL, inserts a row into `studentInfo` using `Statement`
  - Covers the classic 6 steps: load driver → connect → create statement → execute query → process result → close

## Tech used

- Java (JavaSE-25 in Eclipse)
- Eclipse IDE
- MySQL Server running locally (`jdbc:mysql://127.0.0.1:3306/`)
- MySQL Connector/J (`com.mysql.cj.jdbc.Driver`)

## Prerequisites

1. JDK installed
2. Eclipse IDE for Java Developers
3. MySQL Server running locally with a database created, e.g.:
   ```sql
   CREATE DATABASE jdbcLearning;
   USE jdbcLearning;
   CREATE TABLE studentInfo (
     id INT PRIMARY KEY,
     sname VARCHAR(50),
     sage INT,
     scity VARCHAR(50)
   );
   ```
4. MySQL Connector/J jar added to the Eclipse build path as a User Library (e.g. `My SQL Lib`)

> Note: the `jdbc connectors (jar)/` folder with the driver binaries is kept locally only and is **not** tracked in git (see `.gitignore`). Download Connector/J from the [MySQL official site](https://dev.mysql.com/downloads/connector/j/) if you clone this repo.

## How to run in Eclipse

1. Clone the repo:
   ```bash
   git clone https://github.com/<your-username>/jdbc.git
   ```
2. In Eclipse: `File → Open Projects from File System...` → select `firstJDBC_App`
3. Add MySQL Connector/J to the build path:
   `Right-click project → Build Path → Configure Build Path → Libraries → Add External JARs...`
4. Update the DB `url`, `user`, and `password` in `LaunchApp1.java` to match your local MySQL setup
5. Run `me.geetprince.jdbc.LaunchApp1` as a Java Application

Expected output on success:

```text
1 Rows affected
```

## Learning plan

- [x] Setup: Eclipse + MySQL + Connector/J
- [x] `Class.forName()`, `DriverManager.getConnection()`, `Statement.executeUpdate()`
- [ ] `PreparedStatement` (avoid SQL injection)
- [ ] `ResultSet` + `SELECT` queries
- [ ] `UPDATE` / `DELETE`
- [ ] Connection closing with `try-with-resources`
- [ ] Transactions, batch updates
- [ ] Basic DAO pattern

## Project structure

```text
.
├── firstJDBC_App/
│   └── src/
│       └── me/geetprince/jdbc/
│           └── LaunchApp1.java
├── .gitignore
└── README.md
```

## Note on credentials

The sample code currently has local DB credentials hardcoded for learning purposes. Don't reuse real passwords here — I'll move to environment variables / config files as I learn more.

---
Happy learning 🚀
