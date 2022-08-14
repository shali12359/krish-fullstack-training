const express = require("express");
const app = express();
const pool = require("./db");
var cors = require("cors");

app.use(express.json());

const corsOpts = {
  origin: "*",

  methods: ["GET", "POST", "PUT"],

  allowedHeaders: ["Content-Type"],
};

app.use(cors(corsOpts));

app.post("/dispatches", async (req, res) => {
    try {
        console.log(req.body.orderId);

        const orderId = req.body.orderId;
        const newDispatch = await pool.query(
          "INSERT INTO dispatch (order_id) VALUES ($1)",
          [orderId]
        );
    } catch (err) {
        console.error(err.message);
    }
})

app.get("/dispatchOrders", async(req, res) => {
    try {
        const allDispatches = await pool.query("SELECT * FROM order1 WHERE status='Dispatched'");
        res.json(allDispatches.rows);
    } catch (err) {
        console.error(err.message);
    }
})

app.get("/allAllocated", async (req, res) => {
  try {
    const allDispatches = await pool.query(
      "SELECT * FROM order1 WHERE status='Allocated'"
    );
    res.json(allDispatches.rows);
  } catch (err) {
    console.error(err.message);
  }
});

app.put("/updateDispatch/:id", async (req, res) => {
  try {
    const id = Number(req.params.id);
    console.log("Update: " + id);
    const updateDispatch = await pool.query(
      "UPDATE order1 SET status='Dispatched' WHERE order_id = $1",
      [id]
    );
  } catch (err) {
    console.error(err.message);
  }
});

app.listen(3000, () => {
    console.log(`Server Runnig on Port 3000`);
})