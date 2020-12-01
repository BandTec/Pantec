'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Maquina = sequelize.define('Maquina',{	
		id: {
			field: 'id',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		hostname: {
			field: 'hostname',
			type: DataTypes.STRING,
			allowNull: false
		},
		usuario_id: {
			field: 'usuario_id',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	}, 
	{
		tableName: 'maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Maquina;
};
