var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;
var UsuarioAccount = require('../models').UsuarioAccount;
const { QueryTypes } = sequelize;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/autenticar', (req, res, next)=> {
	console.log('Recuperando usuário por login e senha');

	var login = req.body.login; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.senha; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	//modificar o select de acordo com as minhas tabelas
	let instrucaoSql = `select * from usuario where email='${login}' and senha='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.email); //mudar login por email pois é isso que estou usando
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Cadastrar usuário */
router.post('/cadastrar', (req, res, next)=> {
	console.log('Criando um usuário');
	
	const {nome, login, senha, logradouro, cep, bairro, cidade, numero, telefone, tipoDoc, numDoc} = req.body;

	Usuario.create({
		nome: nome, 
		logradouro: logradouro,
		cep: cep,
		bairro: bairro,
		cidade:cidade,
		numero: numero,
		telefone:telefone,
		tipoDoc: tipoDoc,
		numDoc: numDoc
	}).then(async resultado => {
		var idCliente = await sequelize.query('SELECT TOP 1 id FROM pantec.dbo.cliente ORDER BY id DESC', { model: Usuario });
		UsuarioAccount.create({
			email:login,
			senha: senha,
			clienteId: idCliente[0].id
		}).then(resultado => {
			console.log(`Registro criado: ${resultado}`);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		})
		res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/sessao/:login', (req, res, next)=> {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão`);
	
	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/sair/:login', (req, res, next)=> {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', (req, res, next)=> {
	console.log('Recuperando todos os usuários');
	Usuario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});
router.get('/listar',async (req, res, next) => {
	try {
        var q = "SELECT tipoDocumento FROM documento";
        let { select } = req.body.documento;
        const result = await conexao.query(q, (err, data) => {
            if(err) console.log(err);
            console.log(data, "\n", data.recordset, "\n", data.rowsAffected, "\n", data.recordset[0]);
            res.send(result);
            sql.close(); 
        });
        

    } catch (error) {
        console.log(error);
    }
})
module.exports = router;

