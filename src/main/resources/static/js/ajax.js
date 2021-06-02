const express = require('express');
const router = express.Router();

//Get Home page
router.get('/',(req,res,next) => {
    res.send(new Date());
});

module.exports = router;