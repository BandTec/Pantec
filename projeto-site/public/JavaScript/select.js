const Conexao = require("../../config/config");

const listar = async (req,res) => {
    const conexao = Conexao();
    try {
        var q = "SELECT tipoDocumento FROM documento";
        let { select } = req.body.documento;
        const result = await conexao.query(q, (err, data) => {
            if(err) console.log(err);
            console.log(data, "\n", data.recordset, "\n", data.rowsAffected, "\n", data.recordset[0]);
            res.send(data);
            sql.close(); 
        });
        

    } catch (error) {
        console.log(error);
    }
}
module.exports = {
    listar
}