drop database Abarrotes_Valdivia
CREATE DATABASE Abarrotes_Valdivia
use Abarrotes_Valdivia

CREATE TABLE Clientes (
idClien int PRIMARY KEY CHECK(idClien>=1),
nombre_C varchar(43) NOT NULL,
saldo_c int NOT NULL
)

CREATE TABLE Proveedores(
idProv int PRIMARY KEY CHECK(idProv>=1),
nombre_Prov varchar(20) NOT NULL,
telefono_pro int
)

CREATE TABLE Productos(
idProd int PRIMARY KEY CHECK(idProd>=1),
nombre_Prod varchar(25) NOT NULL,
precio decimal(5,2) NOT NULL CHECK(precio>0.0),
stock int NOT NULL CHECK(stock>=0 AND stock<=99),
existencia int NOT NULL CHECK(existencia>=0 AND existencia<=99),
UM varchar(30) NOT NULL
)


CREATE TABLE Ventas_Detalladas(
idV int PRIMARY KEY CHECK(idV>=1),
idClien int NOT NULL CHECK(idClien>=1),
totalV decimal(6,2) NOT NULL CHECK(totalV>0.0),
fecha date,
FOREIGN KEY(idClien) REFERENCES Clientes(idClien)
)

CREATE TABLE Ventas(
idV int CHECK(idV>=1),
idProd int CHECK(idProd>=1),
Cantidad int NOT NULL CHECK(Cantidad>=1 AND Cantidad<=99),
SubtotalV decimal(6,2) NOT NULL CHECK(subtotalV>0.0),
FOREIGN KEY(idProd) REFERENCES Productos(idProd),
FOREIgn KeY(idV) REFERENCES Ventas_Detalladas(idV),
PRIMARY KEY(idV, idProd)
)

CREATE TABLE Compras_Detalladas(
idCom int PRIMARY KEY CHECK(idCom>=1),
idProv int NOT NULL CHECK(idProv>=1),
fechaC date,
totalC decimal(6,2) NOT NULL,
FOREIGN KEY(idProv) REFERENCES Proveedores(idProv)
)

CREATE TABLE Compras(
idCom int CHECK(idCom>=1),
idProd int NOT NULL CHECK(idProd>=1),
Cantidad int NOT NULL CHECK(Cantidad>=1 AND Cantidad<=99),
SubtotalC decimal(6,2) NOT NULL CHECK(subtotalC>0.0),
FOREIGN KEY(idProd) REFERENCES Productos(idProd),
FOREIGN KEY(idCom) REFERENCES Compras_Detalladas(idCom),
PRIMARY KEY(idCom, idProd)
)
---------------------------------------------------------------CLIENTES
--Procedures Clientes insert
create procedure addCliente @idcliente int, @nombreCliente varchar(43), @saldoCliente int 
as 
insert into Clientes values(@idCliente, @nombreCliente, @saldoCliente)
execute addCliente 1, 'Jose', 0
--Procedures Clientes update
create procedure updateCliente @idcliente int, @nombreCliente varchar(43), @saldoCliente int 
as 
update Clientes set nombre_C = @nombreCliente, saldo_c = @saldoCliente where idClien = @idCliente
--Procedures Clientes select idv
create procedure selectCliente @idcliente int
as 
select * from Clientes where idClien = @idcliente
--Procedures Clientes select gen
create procedure selectClientes
as 
select * from Clientes 
--Procedures Clientes delete
create procedure deleteCliente @idcliente int
as
delete from Clientes where idClien = @idcliente
--Procedures Clientes delete nombre
create procedure deleteClienteNombre @nombre varchar(43)
as
delete from Clientes where nombre_C = @nombre
--Procedures Clientes select gen
alter procedure selectClientesNombre @nombre varchar(43)
as 
select * from Clientes where nombre_C like '%'+@nombre+'%'
--Procedure clientes select TOP 1
CREATE PROCEDURE selectCliente1
AS
SELECT TOP 1 idClien FROM Clientes ORDER BY idClien DESC

---------------------------------------------------------------PRODUCTOS
--Procedures Productos insert 
create procedure addProduct @idproducto int, @nombreproducto varchar(25), @preSio decimal(5,2), @stocks int, @existencias int, @ums varchar(30)
as
insert into Productos values (@idproducto, @nombreproducto, @preSio, @stocks, @existencias, @ums )
execute addProduct 3, 'Coca', 12.2, 1, 1, 'lit' -- Esto para que sirve?
--Procedures Productos select ind
create procedure selectProduc @idproduc int
as
select * from Productos where idProd = @idproduc

--Procedures Productos select gen 
create procedure selectProducs
as
select * from Productos 

--Procedures Products Where Nombre_Prod
create procedure selectProductNombre @Nombre_Prod varchar(25)
as
select * from Productos where nombre_Prod like '%' + @Nombre_Prod + '%'
--Procedures Products Where Precio
create procedure selectProductPrecio @Precio decimal(5,2)
as
select * from Productos where precio = @Precio
--Procedures Products Where Existencia
create procedure selectProductExistencia @Existencia int
as
select * from Productos where existencia = @Existencia

execute selectProductExistencia -1
--Procedures Productos update
create procedure updateProduct @idproducto int, @nombreproducto varchar(25), @preSio decimal(5,2), @stocks int, @existencias int, @ums varchar(30)
as
update Productos set nombre_Prod = @nombreproducto,precio = @preSio ,stock = @stocks,existencia = @existencias , UM= @ums where idProd = @idproducto

--PROCEDURE productos updateProductoExistencia
CREATE PROCEDURE updateProductExistencia @idprod int, @existencia INT
AS
UPDATE Productos set existencia = @existencia where idProd = @idprod

EXECUTE updateProductExistencia 1, 9
--Procedures Productos delete
create procedure deleteProduct @idproducto int
as
delete from Productos where idProd = @idproducto

execute deleteProduct 3
--Procedure GetLastID from Product
create procedure getLastIDProduct
as
select top 1 IDPROD from Productos order by idProd desc

execute getLastIDProduct
---------------------------------------------------------------PROVEEDORES
--++++++++++++++++++ AGREGAR ++++++++++++++++++

--Procedures Proveedores insert
create procedure insertProv @id int, @nom varchar(20), @tel int
as
insert into Proveedores values( @id, @nom , @tel )

--++++++++++++++++++ CONSULTAR ++++++++++++++++++

--Procedure Proveedores select by Id
create procedure selectProvById @id int
as
select * from Proveedores where idProv = @id

--Procedure Proveedores select by Name
CREATE PROCEDURE selectProvByName @name varchar(20)
AS
SELECT * FROM Proveedores WHERE nombre_Prov = @name

--Procedure Proveedores select by Tel
CREATE PROCEDURE selectProvByTel @tel int
AS
SELECT * FROM Proveedores WHERE telefono_pro = @tel

--Procedures Proveedores select All
create procedure selectProvs 
as
select * from Proveedores 

--Procedure Proveedores select TOP 1
CREATE PROCEDURE selectProvTOP
AS
SELECT TOP 1 idProv FROM Proveedores ORDER BY idProv DESC


--++++++++++++++++++ UPDATE ++++++++++++++++++

--Procedures Proveedores update
create procedure updateProv @id int, @nom varchar(20), @tel int
as
update Proveedores set  nombre_Prov = @nom ,telefono_pro = @tel where idProv = @id 


--++++++++++++++++++ DELETE ++++++++++++++++++

--Procedures Proveedores delete by ID
create procedure deleteProvById @id int
as
delete from Proveedores where idProv = @id

--Procedure Delete Proveedor by Nombre
CREATE PROCEDURE deleteProvByName @name varchar(20) 
AS
DELETE FROM Proveedores WHERE nombre_Prov = @name


---------------------------------------------------------------VENTAS_DETALLADAS
--Procedures Ventas_Detalladas insert
create procedure insert_VD @id int, @idc int, @total decimal(6,2)
as
insert into Ventas_Detalladas values (@id , @idc , @total, GETDATE() )
execute insert_VD 5, 1, 6.66

insert into Clientes values 

--Procedures Ventas_Detalladas select ind
create procedure selectVD @id int
as
select * from Ventas_Detalladas where idV = @id

execute selectVD 2
--Procedures Ventas_Detalladas select gen
create procedure selectVDs 
as
select * from Ventas_Detalladas 

execute selectVDs
--Procedures Ventas_Detalladas Select Fecha
create procedure selectVD_Fecha @fecha date
as
select * from Ventas_Detalladas where fecha = @fecha

execute selectVD_Fecha '2021-4-8'
--Procedures Ventas_Detalladas Select_IDCLIEN
create PROCEDURE selectVD_IDCLIEN @IDCLIEN INT
AS
select * FROM Ventas_Detalladas WHERE idClien = @IDCLIEN

EXECUTE selectVD_IDCLIEN 1

--PROCEDURES Ventas_Detalladas select TotalVenta
create PROCEDURE selectVD_TotalVenta @TotalV decimal(6,2)
AS
SELECT * FROM Ventas_Detalladas where totalV = @TotalV

EXECUTE selectVD_TotalVenta 666.66

--Procedures Ventas_Detalladas delete gen
create procedure deleteVD @id int
as
delete from Ventas_Detalladas where idV = @id
--Procedures Ventas_Detalladas update
create procedure updateVD  @id int, @idc int, @total decimal(6,2)
as
update Ventas_Detalladas set  idClien = @idc , totalV = @total where idV = @id

---------------------------------------------------------------VENTAS
--Procedures Ventas insert
create procedure addVenta @id int, @product int , @cant int, @sub decimal(6,2)
as
insert into Ventas values (@id, @product, @cant, @sub)
execute addVenta 1,2,2,123.2
--Procedures Ventas select ind
create procedure selectVenta @id int
as
select * from Ventas where idV = @id

EXECUTE selectVenta 2
--Procedures Ventas select gen
create procedure selectVentas
as
select * from Ventas 

EXECUTE selectVentas

--Procedures Ventas select Producto
create procedure selectVenta_Producto @id int
as
select * from Ventas where idProd = @id

EXECUTE selectVenta_Producto 2

--Procedures Ventas select Cantidad
create procedure selectVenta_Cantidad @cantidad int
as
select * from Ventas where Cantidad = @cantidad

EXECUTE selectVenta_Cantidad 1

--Procedures Ventas select SubtotalV
create procedure selectVenta_SubtotalV @subtotalv decimal(6,2)
as
select * from Ventas where SubtotalV = @subtotalv

EXECUTE selectVenta_SubtotalV -1

--Procedures Ventas update
create procedure updateVenta @id int, @product int , @cant int, @sub decimal(6,2)
as
update Ventas set idProd = @product,Cantidad = @cant, SubtotalV = @sub where idV = @id
--Procedures Ventas delete
create procedure deleteVenta @id int
as
delete from Ventas where idV = @id

--Procedures Productos select ind
create procedure selectProduc @idproduc int
as
select * from Productos where idProd = @idproduc

--Procedures Productos select gen 
create procedure selectProducs
as
select * from Productos 

--Procedures Products Where Nombre_Prod
create procedure selectProductNombre @Nombre_Prod varchar(25)
as
select * from Productos where nombre_Prod like '%' + @Nombre_Prod + '%'

execute selectProductNombre 'coc'
--Procedures Products Where Precio
create procedure selectProductPrecio @Precio decimal(5,2)
as
select * from Productos where precio = @Precio
--Procedures Products Where Existencia
create procedure selectProductExistencia @Existencia int
as
select * from Productos where existencia = @Existencia


---------------------------------------------------------------COMPRAS_DETALLADAS
--Procedures COMPRAS_DETALLADAS insert
create procedure insert_CD @id int, @idc int, @total decimal(6,2)
as
insert into Compras_Detalladas values (@id , @idc , GETDATE(), @total  )
--Procedures COMPRAS_DETALLADASs select ind
create procedure selectCD @id int
as
select * from Compras_Detalladas where idCom = @id
--Procedures COMPRAS_DETALLADAS select gen
create procedure selectCDs 
as
select * from Compras_Detalladas 
--Procedures COMPRAS_DETALLADAS delete gen
create procedure deleteCD @id int
as
delete from Compras_Detalladas where idCom = @id
--Procedures COMPRAS_DETALLADAS update
create procedure updateCD  @id int, @idc int, @total decimal(6,2)
as
update Compras_Detalladas set  idProv = @idc , totalC = @total where idCom = @id
---------------------------------------------------------------COMPRAS_DETALLADAS
--Procedures COMPRAS insert
create procedure addCompras @id int, @product int , @cant int, @sub decimal(6,2)
as
insert into Compras values (@id, @product, @cant, @sub)
--Procedures COMPRAS select ind
create procedure selectCompra @id int
as
select * from Compras where idCom = @id
--Procedures COMPRAS select gen
create procedure selectCompras
as
select * from Compras 
--Procedures COMPRAS update
create procedure updateCompras @id int, @product int , @cant int, @sub decimal(6,2)
as
update Compras set idProd = @product,Cantidad = @cant, SubtotalC = @sub where idCom = @id
--Procedures COMPRAS delete
create procedure deleteCompras @id int
as
delete from Compras where idCom = @id
-----------------------------------------------------------------PROCEDIMIENTOS-GRENAS-COMPRAS
---------------------------ORDENAR PRODUCTOS-PARA-TABLA-------------------------------------------------
create procedure OrdID
as
select * from Productos ORDER BY IDPROD ASC

create procedure OrdIDEx
as
select * from Productos where IDPROD = 0

create procedure OrdNom @nombre varchar(50)
as
select * from Productos WHERE Nombre_Prod like '%'+@nombre+'%'

create procedure OrdPrecio
as
select * from Productos ORDER BY PRECIO ASC

create procedure OrdPrecioEx
as
select * from Productos WHERE Precio = 0

create procedure OrdExistencia
as
select * from Productos ORDER BY EXISTENCIA ASC

create procedure OrdExistenciaEx
as
select * from Productos WHERE Existencia = 0
--------------------FIN--------------------------------------------------------------------

---LLENAR-JCB-CON-PROVEEDORES----------------------------------
create procedure consultaProv
as
SELECT * FROM Proveedores ORDER BY IDPROV ASC
------------------FIN------------------------------------------

-----------------ID-COMPRAS-UI-------------------------
create procedure getLastIDCs
as
SELECT TOP 1 IDCOM FROM Compras_Detalladas ORDER BY IDCOM DESC
------------------------FIN------------------------------------

---------------ORDENAR-PRODUCTOS-PARA-TABLA-CON-PROVEEDORES------------------------------
create procedure PROVidNomb @nombre varchar(50)
as
select IDPROV from Proveedores where Nombre_PROV like @nombre

create procedure PROVidCsProv @idprov int
as
select idprov from Compras_Detalladas where IDPROV = @idprov

create procedure PRODidCDs
as
select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom

create procedure PRODidCDsProv @idprov int
as
select IDPROD from Compras, Compras_Detalladas where compras.IDCOM = Compras_Detalladas.idcom and IDPROV = 2

execute PRODidCDsProv 1
-----------------------------FIN---------------------------------------------------------

---------------ORDENAR-PRODUCTOS-PARA-TABLA-CON-PROVEEDORES-Y-RADIO-BUTTON-----------------------------

-----------------------------------FIN-------------------------------------------------------

----------------COMPRAS_MISCELANEO------------------------------------

create procedure CDprovID @nombre varchar(50)
as
SELECT IDPROV FROM Proveedores WHERE Nombre_PROV LIKE @nombre 

create procedure UpdateEx @existencia int, @idp int
as
update Productos set Existencia = @existencia where IDPROD = @idp

create procedure ExistenciaConsul @idp int
as
SELECT Existencia FROM Productos WHERE IDPROD = 2

create procedure getLastProvID
as
SELECT TOP 1 * FROM Proveedores ORDER BY idProv DESC
-------------------------FIN-----------------------------------------------------
create procedure PRODnotIn
as
SELECT * FROM Productos WHERE NOT EXISTS (SELECT * FROM compras WHERE Compras.idProd = Productos.idProd)

create procedure PRODIn @idProve int
as
declare @comp as table (idC int)
insert into @comp select idCom from Compras_Detalladas where @idProve = Compras_Detalladas.idProv
declare @prods as table (ids int)
insert into @prods select idProd from Compras where Compras.idCom in (select * from @comp)
declare @prodsOG as table (idProd int, nombre varchar(25), precio decimal(5,2), stock int, existencia int, UM varchar(30))
insert into @prodsOG SELECT * FROM Productos WHERE Productos.idProd in (select * from @prods)
select * from @prodsOG

create procedure PRODInPrecio @idProve int
as
declare @comp as table (idC int)
insert into @comp select idCom from Compras_Detalladas where @idProve = Compras_Detalladas.idProv
declare @prods as table (ids int)
insert into @prods select idProd from Compras where Compras.idCom in (select * from @comp)
declare @prodsOG as table (idProd int, nombre varchar(25), precio decimal(5,2), stock int, existencia int, UM varchar(30))
insert into @prodsOG SELECT * FROM Productos WHERE Productos.idProd in (select * from @prods)
select * from @prodsOG order by precio asc

create procedure PRODInExistencia @idProve int
as
declare @comp as table (idC int)
insert into @comp select idCom from Compras_Detalladas where @idProve = Compras_Detalladas.idProv
declare @prods as table (ids int)
insert into @prods select idProd from Compras where Compras.idCom in (select * from @comp)
declare @prodsOG as table (idProd int, nombre varchar(25), precio decimal(5,2), stock int, existencia int, UM varchar(30))
insert into @prodsOG SELECT * FROM Productos WHERE Productos.idProd in (select * from @prods)
select * from @prodsOG order by existencia asc

create procedure PRODInNombre @idProve int, @nombre varchar(60)
as
declare @comp as table (idC int)
insert into @comp select idCom from Compras_Detalladas where @idProve = Compras_Detalladas.idProv
declare @prods as table (ids int)
insert into @prods select idProd from Compras where Compras.idCom in (select * from @comp)
declare @prodsOG as table (idProd int, nombre varchar(25), precio decimal(5,2), stock int, existencia int, UM varchar(30))
insert into @prodsOG SELECT * FROM Productos WHERE Productos.idProd in (select * from @prods) and Productos.nombre_Prod like '%'+@nombre+'%'
select * from @prodsOG


