'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let AlunosAulas = sequelize.define('AlunosAulas',{
		idAluno: {
			field: 'fk_aluno',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		idAula: {
			field: 'fk_aula',
            type: DataTypes.INTEGER,
            primaryKey: true,
			allowNull: false
		},
		pontuacao: {
			field: 'nota',
			type: DataTypes.STRING,
			allowNull: false
		},
		validado: {
			field: 'validado',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	}, 
	{
		tableName: 'AlunosAulas', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return AlunosAulas;
};
