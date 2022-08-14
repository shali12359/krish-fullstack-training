const Pool = require("pg").Pool;

const pool = new Pool({
    user: "postgres",
    password: "14491",
    database: "fuelapp",
    host: "localhost",
    port: 5432
})

module.exports = pool;