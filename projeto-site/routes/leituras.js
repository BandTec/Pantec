var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;
var Maquina = require('../models').Maquina;

var hostname;
var id;
var email;
router.post('/enviar', (req, res)=>{
	hostname = req.body.tentativa;
	id = req.body.inp;
	email = req.body.usuario;
	hostname_two = req.body.segunda;
	console.log("HOST:    "+hostname_two)
	console.log("VALOR   "+hostname)
	console.log("VALOR ID "+ id)
	console.log("VALOR ID "+ email)
})

router.get('/select', (req, res)=>{
	
	const instrucaoSql =`select hostname from maquina where usuario_id=(select id from usuario where email='${email}')`;
	sequelize.query(instrucaoSql, {
		model: Maquina,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
})

router.get('/comparacao',(req, res, next) =>{
	const limite_linhas = 7;
	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
  
   
	const instrucaoSql = `select top 7
							componente, 
							uso, 
							momento,
							maquina_id,
							FORMAT(momento,'HH:mm:ss') as momento_grafico 
							from registro where componente=1 and maquina_id=(select id from maquina where hostname='${hostname_two}' and usuario_id='${id}') order by id desc`;

	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
})




router.get('/cpu',(req, res, next) => {
   
	 const limite_linhas = 7;
 	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
   
	
 	const instrucaoSql = `select top 7
 							componente, 
 							uso, 
 							momento,
 							maquina_id,
 							FORMAT(momento,'HH:mm:ss') as momento_grafico 
 							from registro where componente=1 and maquina_id=(select id from maquina where hostname='${hostname}' and usuario_id='${id}') order by id desc`;

 	sequelize.query(instrucaoSql, {
 		model: Leitura,
 		mapToModel: true 
 	  })
 	  .then(resultado => {
 			console.log(`Encontrados: ${resultado.length}`);
 			res.json(resultado);
 	  }).catch(erro => {
 			console.error(erro);
 			res.status(500).send(erro.message);
 	  });
 });


 router.get('/disco',(req, res, next) => {
   

 	const limite_linhas = 1;

 	console.log(`Recuperando a última leituras`);
   
 	const instrucaoSql = `select top ${limite_linhas}
 							componente, 
 							uso, 
 							momento,
 							maquina_id,
 							FORMAT(momento,'HH:mm:ss') as momento_grafico 
 							from registro where componente=2 and maquina_id=(select id from maquina where hostname='${hostname}' and usuario_id='${id}') order by id desc`;

 	sequelize.query(instrucaoSql, {
 		model: Leitura,
 		mapToModel: true 
 	  })
 	  .then(resultado => {
 			console.log(`Encontrados: ${resultado.length}`);
 			res.json(resultado);
 	  }).catch(erro => {
 			console.error(erro);
 			res.status(500).send(erro.message);
 	  });
 });

 router.get('/comparacao-disco',(req, res, next) => {
   

	const limite_linhas = 3;

	console.log(`Recuperando a última leituras`);
  
	const instrucaoSql = `select top ${limite_linhas}
							componente, 
							uso, 
							momento,
							maquina_id,
							FORMAT(momento,'HH:mm:ss') as momento_grafico 
							from registro where componente=2 and maquina_id=(select id from maquina where hostname='${hostname_two}' and usuario_id='${id}') order by id desc`;

	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
});

 router.get('/mem',(req, res, next) => {
   
 	const limite_linhas = 1;

 	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
   
 	const instrucaoSql = `select top ${limite_linhas}
 							componente, 
 							uso, 
 							momento,
 							maquina_id,
 							FORMAT(momento,'HH:mm:ss') as momento_grafico 
 							from registro where componente=3 and maquina_id=(select id from maquina where hostname='${hostname}' and usuario_id='${id}') order by id desc`;

 	sequelize.query(instrucaoSql, {
 		model: Leitura,
 		mapToModel: true 
 	  })
 	  .then(resultado => {
 			console.log(`Encontrados: ${resultado.length}`);
 			res.json(resultado);
 	  }).catch(erro => {
 			console.error(erro);
 			res.status(500).send(erro.message);
 	  });
 });

 router.get('/comparacao-mem',(req, res, next) => {
   
	const limite_linhas = 3;

	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
  
	const instrucaoSql = `select top ${limite_linhas}
							componente, 
							uso, 
							momento,
							maquina_id,
							FORMAT(momento,'HH:mm:ss') as momento_grafico 
							from registro where componente=3 and maquina_id=(select id from maquina where hostname='${hostname_two}' and usuario_id='${id}') order by id desc`;

	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
});

 router.get('/gpu',(req, res, next) => {
   
 	const limite_linhas = 7;

 	console.log(`Recuperando as últimas ${limite_linhas} leituras`);
   
 	const instrucaoSql = `select top 7
 							componente, 
 							uso, 
 							momento,
 							maquina_id,
 							FORMAT(momento,'HH:mm:ss') as momento_grafico 
 							from registro where componente=4 and maquina_id=(select id from maquina where hostname='${hostname}' and usuario_id='${id}') order by id desc`;

 	sequelize.query(instrucaoSql, {
 		model: Leitura,
 		mapToModel: true 
 	  })
 	  .then(resultado => {
 			console.log(`Encontrados: ${resultado.length}`);
 			res.json(resultado);
 	  }).catch(erro => {
 			console.error(erro);
 			res.status(500).send(erro.message);
 	  });
 });

 router.get('/processos',(req,res) => {
	const instrucaoSql = `select top 3
							componente, 
							uso, 
							momento,
							maquina_id,
							momento,
							processos 
							from registro where componente=5 and maquina_id=(select id from maquina where hostname='${hostname}' and usuario_id='${id}') order by id desc
	`;
	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
 })


 router.get('/processos-duo',(req,res) => {
	const instrucaoSql = `select top 3
							componente, 
							uso, 
							momento,
							maquina_id,
							momento,
							processos 
							from registro where componente=5 and maquina_id=(select id from maquina where hostname='${hostname_two}' and usuario_id='${id}') order by id desc
	`;
	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true 
	  })
	  .then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
	  }).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
	  });
 })

module.exports = router;