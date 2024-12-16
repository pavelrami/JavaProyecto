Video demostrativo del funcionamiento del punto de venta: https://www.youtube.com/watch?v=_99EhVjbg6A
1. Descripción del Proyecto
Este proyecto es un Sistema de Punto de Venta (TPV) para una tienda de discos. Está diseñado para gestionar las operaciones diarias de una tienda de música, como la venta de discos, el registro de clientes y proveedores, y la gestión de inventarios. El sistema facilita el control de stock, el registro de ventas y la actualización de productos, y está desarrollado en Java con NetBeans y PostgreSQL como sistema de gestión de bases de datos. El objetivo principal es proporcionar una solución fácil de usar para el manejo de las operaciones comerciales de la tienda.

Objetivo

Facilitar la venta de discos y otros productos relacionados.
Mantener un control eficiente de inventarios.
Gestionar clientes y proveedores de manera eficiente.
Proporcionar una interfaz gráfica amigable para usuarios no técnicos.
2. Instrucciones de Instalación y Configuración
Requisitos Previos

Java 8 o superior instalado en tu sistema.
NetBeans IDE 8.2 o superior (o cualquier otro IDE compatible con Java).
PostgreSQL 12 o superior.
Git para gestionar el código fuente.
JDBC (Java Database Connectivity) para la conexión con PostgreSQL.
Pasos de Instalación

Clonar el Repositorio
Clona el repositorio desde GitHub:

bash
Copiar código
git clone https://github.com/gabriel0n/tDMusica.git
Configurar la Base de Datos
Instalar PostgreSQL:

Si no tienes PostgreSQL instalado, puedes descargarlo desde aquí https://www.postgresql.org/download/
.
Crear una base de datos llamada tienda_discos y las tablas necesarias para el proyecto:

clientes: Información de los clientes.
proveedores: Información de los proveedores.
productos: Información de los discos.
ventas: Registro de las ventas realizadas.
Asegúrate de que tu base de datos esté configurada con un usuario y una contraseña correctos para la conexión.

Configuración de la conexión a la base de datos: En el proyecto, encontrarás un archivo de configuración donde deberás ingresar los datos de la base de datos:

java
Copiar código
String url = "jdbc:postgresql://localhost:5432/tienda_discos";
String user = "tu_usuario";
String password = "tu_contraseña";
Instalar Dependencias
El proyecto utiliza JDBC para interactuar con la base de datos y Swing para la interfaz gráfica, que vienen con el JDK, por lo que no se necesita instalar dependencias adicionales.

Ejecutar el Proyecto
Abre el proyecto en NetBeans o tu IDE de preferencia.
Asegúrate de que la base de datos PostgreSQL esté corriendo y accesible.
Ejecuta la clase MainFrame.java para iniciar la interfaz gráfica del sistema.
3. Explicación del Funcionamiento y la Estructura de la Base de Datos
La base de datos está diseñada para gestionar la información relevante para el funcionamiento de una tienda de discos. Se compone de las siguientes tablas principales:

Tabla: clientes

Campo	Tipo	Descripción
id	SERIAL	Identificador único del cliente
rfc	VARCHAR	RFC del cliente (alfanumérico)
nombre	VARCHAR	Nombre completo del cliente
telefono	VARCHAR	Número telefónico del cliente
direccion	TEXT	Dirección del cliente
Tabla: proveedores

Campo	Tipo	Descripción
id	SERIAL	Identificador único del proveedor
rfc	VARCHAR	RFC del proveedor (alfanumérico)
nombre	VARCHAR	Nombre completo del proveedor
telefono	VARCHAR	Número telefónico del proveedor
Tabla: productos (discos)

Campo	Tipo	Descripción
id	SERIAL	Identificador único del producto
codigo	VARCHAR	Código único del producto (disco)
nombre	VARCHAR	Nombre del disco
precio	DECIMAL	Precio de venta del disco
stock	INT	Cantidad disponible en inventario
Tabla: ventas

Campo	Tipo	Descripción
id	SERIAL	Identificador único de la venta
cliente_id	INT	ID del cliente que realiza la venta
total	DECIMAL	Total de la venta
fecha	DATE	Fecha de la venta
Relaciones entre las Tablas

La tabla ventas está relacionada con la tabla clientes mediante el campo cliente_id.
La tabla productos mantiene el inventario de discos en la tienda, y la venta actualiza la cantidad de stock disponible al realizar una compra.
4. Resumen de Cada Clase y sus Responsabilidades
Clase: Cliente.java

Responsabilidad: Esta clase representa a los clientes de la tienda. Permite almacenar la información personal de cada cliente, como su nombre, RFC, teléfono y dirección.
Métodos principales:
getId(): Retorna el ID del cliente.
setNombre(String nombre): Establece el nombre del cliente.
validarRFC(String rfc): Valida que el RFC sea correcto.
Clase: Proveedor.java

Responsabilidad: Esta clase representa a los proveedores de los discos. Contiene información como el nombre, RFC y teléfono del proveedor.
Métodos principales:
getId(): Retorna el ID del proveedor.
setNombre(String nombre): Establece el nombre del proveedor.
validarRFC(String rfc): Valida que el RFC del proveedor sea correcto.
Clase: Producto.java

Responsabilidad: Representa los discos disponibles en la tienda. Almacena la información como el código, nombre, precio y cantidad en inventario.
Métodos principales:
getId(): Retorna el ID del producto.
getCodigo(): Retorna el código del producto.
actualizarStock(int cantidad): Actualiza el stock después de una venta.
Clase: Venta.java

Responsabilidad: Representa una venta realizada en la tienda. Contiene los detalles de la venta, como el cliente, el total de la venta y la fecha.
Métodos principales:
registrarVenta(): Registra una nueva venta en la base de datos.
actualizarStockProducto(int idProducto, int cantidad): Actualiza el stock del producto vendido.
Clase: MainFrame.java

Responsabilidad: Esta es la clase principal que contiene la interfaz gráfica del sistema (GUI). Permite a los usuarios interactuar con el sistema mediante formularios para agregar productos, registrar ventas, etc.
Métodos principales:
iniciarAplicacion(): Inicia la aplicación y muestra la ventana principal.
mostrarFormularioClientes(): Muestra el formulario para agregar o editar clientes.
mostrarFormularioVentas(): Muestra el formulario para registrar ventas.
Clase: ConexionBD.java

Responsabilidad: Gestiona la conexión con la base de datos PostgreSQL. Establece la conexión utilizando JDBC y maneja las operaciones de consulta, inserción, actualización y eliminación.
Métodos principales:
conectar(): Establece la conexión con la base de datos.
desconectar(): Cierra la conexión con la base de datos.
5. Contribución
Si deseas contribuir a este proyecto, sigue estos pasos:

Forkea el repositorio.
Crea una nueva rama para tu contribución.
Realiza los cambios necesarios y crea un Pull Request.
Asegúrate de que el código esté bien documentado y probado.
6. Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
