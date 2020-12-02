'use strict';

module.exports = (sequelize, DataTypes) => {
    let UsuarioAccount = sequelize.define('UsuarioAccount',{
        id: {
            field: 'id',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        email: {
            field: 'email',
            type: DataTypes.STRING,
            allowNull: false
        },
        senha:{
            field: 'senha',
            type: DataTypes.STRING,
            allowNull: false
        },
        clienteId:{
            field: 'cliente_id',
            type: DataTypes.INTEGER,
            allowNull: false
        }
    },
    {
        tableName: 'usuario',
        freezeTableName: true, 
		underscored: true,
		timestamps: false,
    });
    return UsuarioAccount;
};