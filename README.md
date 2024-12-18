Video demostrativo del funcionamiento del punto de venta: https://www.youtube.com/watch?v=_99EhVjbg6A
# Sistema de Gestión de Tienda de Discos

Este proyecto es un **Sistema de Gestión de Tienda de Discos** desarrollado en **Java** utilizando el entorno de desarrollo **NetBeans** y una base de datos relacional en **MySQL XAMPP**. El sistema está diseñado para permitir una administración eficiente de clientes, productos, proveedores y ventas, ofreciendo una experiencia amigable para administradores, cajeros y usuarios finales.

---

## **Características Principales**

### **Gestión de Usuarios y Roles**

![image](https://github.com/user-attachments/assets/7630a21a-46dc-4c06-bd55-87302db47441)
- **Roles disponibles**: Administrador y Cajero.
- **Validación de permisos** para cada rol, asegurando accesos restringidos a las funciones correspondientes.
- **Inicio de sesión** con autenticación basada en correo electrónico y contraseña.

![image](https://github.com/user-attachments/assets/5e3a2a79-0c27-4b82-82d7-e0e859f614c7)

### **Gestión de Inventario de Discos**

- **Operaciones disponibles**:
  - Agregar discos nuevos.
  - Modificar detalles de los discos (nombre, código, stock, precio, género).
  - Eliminar discos existentes.
  - Controlar el stock y la disponibilidad de los discos.
  ![image](https://github.com/user-attachments/assets/fd24f1c1-30e9-4006-b34f-55aa5712bf76)

- **Validación de entradas** en los formularios:
  - Código: Solo letras y números.
  - Nombre: Solo letras.
  - Stock: Solo números enteros.
  - Precio: Números enteros o decimales.
  ![image](https://github.com/user-attachments/assets/458660ef-20f0-4716-a001-6264293825a2)

### **Gestión de Clientes**

- **Operaciones disponibles**:
  - Agregar nuevos clientes.
  - Modificar datos de los clientes.
  - Eliminar clientes.
    ![image](https://github.com/user-attachments/assets/5023fd39-63d7-414f-a25e-7769f1a0426f)
    
- **Validaciones de datos**:
  - RFC: Letras y números.
  - Nombre: Solo letras.
  - Teléfono: Solo números.

### **Gestión de Proveedores**

- **Operaciones disponibles**:
  - Agregar nuevos proveedores.
  - Modificar datos de los proveedores.
  - Eliminar proveedores.
- **Validaciones de datos** similares a las de clientes.

### **Gestión de Ventas**

- **Registrar ventas** de discos a clientes.
- **Actualizar el stock automáticamente** después de cada venta.
- **Eliminar ventas** y recalcular el total de la venta si se eliminan productos.
- **Control de duplicados** en el código de productos.
![image](https://github.com/user-attachments/assets/f882301f-7507-455d-880e-026d3761a1e0)


### **Interfaz de Usuario**

- **Diseño intuitivo y fácil de usar**.
- **Validaciones visuales** para evitar errores en los formularios.
- **Pestañas de navegación** para diferenciar entre roles (Administrador y Cajero).

### **Base de Datos en MySQL**

- **Tablas principales**:
  - `clientes`: Información de los clientes.
  - `proveedores`: Información de los proveedores.
  - `productos`: Inventario de discos.
  - `ventas`: Registro de ventas realizadas.
    ![image](https://github.com/user-attachments/assets/98d9bd72-265c-44c1-914e-fea5e81a53a8)
    
- **Transacciones seguras** para garantizar la integridad de los datos.

---

## **Instrucciones de Instalación y Configuración**

### **Requisitos Previos**

- **Java JDK 8 o superior**
- **NetBeans IDE**
- **XAMPP y MySQL**

### **Instalación del Proyecto**

1. **Clonar el repositorio** desde GitHub:
   ```bash
   git clone https://github.com/tuusuario/tienda-discos.git
   ```

2. **Abrir el proyecto en NetBeans**:
   - Ve a `File > Open Project` y selecciona la carpeta del proyecto.
![image](https://github.com/user-attachments/assets/7875f854-5051-43c9-bd34-978e81f14ab8)

3. **Configurar la base de datos XAMPP**:
   - Crear una base de datos llamada `tienda_discos`.
   - Importar el esquema de base de datos (`tienda_discos.sql`) que se encuentra en la carpeta `database` del proyecto.

4. **Configurar la conexión a la base de datos** en la clase `Conexion.java`:

   ```java
   public class Conexion {
       private static final String URL = "jdbc:postgresql://localhost:5432/tienda_discos";
       private static final String USER = "app_user";
       private static final String PASSWORD = "app_password";

       public static Connection getConnection() throws SQLException {
           return DriverManager.getConnection(URL, USER, PASSWORD);
       }
   }
   ```

5. **Ejecutar el proyecto** desde NetBeans:
   - Haz clic derecho en el proyecto y selecciona `Run`.

---

## **Explicación de la Estructura de la Base de Datos**

La base de datos está compuesta por las siguientes tablas:

### **1. `clientes`**
| Columna    | Tipo de Dato | Descripción             |
|------------|--------------|-------------------------|
| `id`      | SERIAL       | Identificador único     |
| `rfc`     | VARCHAR(13)  | RFC del cliente         |
| `nombre`  | VARCHAR(100) | Nombre del cliente      |
| `telefono`| VARCHAR(15)  | Teléfono del cliente    |
| `direccion` | VARCHAR(255)| Dirección del cliente   |

### **2. `proveedores`**
| Columna       | Tipo de Dato | Descripción                     |
|---------------|--------------|---------------------------------|
| `id`         | SERIAL       | Identificador único             |
| `rfc`        | VARCHAR(13)  | RFC del proveedor               |
| `nombre`     | VARCHAR(100) | Nombre del proveedor            |
| `telefono`   | VARCHAR(15)  | Teléfono del proveedor          |
| `direccion`  | VARCHAR(255) | Dirección del proveedor         |

### **3. `productos`**
| Columna       | Tipo de Dato | Descripción                         |
|---------------|--------------|-------------------------------------|
| `id`         | SERIAL       | Identificador único                 |
| `codigo`     | VARCHAR(10)  | Código único del producto           |
| `nombre`     | VARCHAR(100) | Nombre del disco                    |
| `stock`      | INT          | Cantidad disponible                 |
| `precio`     | DECIMAL(10,2)| Precio del disco                    |

### **4. `ventas`**
| Columna       | Tipo de Dato | Descripción                         |
|---------------|--------------|-------------------------------------|
| `id`         | SERIAL       | Identificador único                 |
| `id_cliente` | INT          | Clave foránea a `clientes`          |
| `fecha`      | DATE         | Fecha de la venta                   |
| `total`      | DECIMAL(10,2)| Total de la venta                   |

---
## 🗂️ **Estructura de la Base de Datos**

### **Tablas Principales**

1.  **`cliente`**: Almacena información de los clientes.
2.  **`proveedor`**: Almacena información de los proveedores.
3.  **`producto`**: Contiene detalles de los discos disponibles.
4.  **`venta`**: Registra cada venta realizada.
5.  **`detalle_venta`**: Contiene detalles individuales de cada producto vendido en una venta.

----------

## 📦 **Resumen de Clases**

### **1. Clase `Cliente`**

-   **Responsabilidad**: Gestiona los datos de los clientes.
-   **Atributos**:
    -   `id`: Identificador único.
    -   `rfc`: RFC del cliente.
    -   `nombre`: Nombre del cliente.
    -   `telefono`: Teléfono del cliente.
    -   `direccion`: Dirección del cliente.

### **2. Clase `Proveedor`**

-   **Responsabilidad**: Maneja los datos de los proveedores.
-   **Atributos** similares a los de `Cliente`.

### **3. Clase `Producto`**

-   **Responsabilidad**: Gestiona los discos disponibles para la venta.
-   **Atributos**:
    -   `codigo`: Código único del producto.
    -   `nombre`: Nombre del disco.
    -   `stock`: Cantidad disponible.
    -   `precio`: Precio del disco.

### **4. Clase `Venta`**

-   **Responsabilidad**: Gestiona las ventas realizadas en la tienda.
-   **Atributos**:
    -   `id`: Identificador único.
    -   `cliente_id`: ID del cliente que realiza la compra.
    -   `fecha`: Fecha de la venta.
    -   `total`: Importe total de la venta.

**Clase: MainFrame.java**

-   **Responsabilidad**: Esta es la clase principal que contiene la interfaz gráfica del sistema (GUI). Permite a los usuarios interactuar con el sistema mediante formularios para agregar productos, registrar ventas, etc.
-   **Métodos principales**:
    -   `iniciarAplicacion()`: Inicia la aplicación y muestra la ventana principal.
    -   `mostrarFormularioClientes()`: Muestra el formulario para agregar o editar clientes.
    -   `mostrarFormularioVentas()`: Muestra el formulario para registrar ventas.

**Clase: ConexionBD.java**

-   **Responsabilidad**: Gestiona la conexión con la base de datos PostgreSQL. Establece la conexión utilizando JDBC y maneja las operaciones de consulta, inserción, actualización y eliminación.
-   **Métodos principales**:
    -   `conectar()`: Establece la conexión con la base de datos.
    -   `desconectar()`: Cierra la conexión con la base de datos.

----------

## 🖼️ **Capturas de Pantalla**

## 🖥️ Pantalla de Inicio de Sesión

Esta es la **pantalla de inicio de sesión** para el sistema de gestión de la tienda de discos .

![Inicio de sesión para el administrador
![image](https://github.com/user-attachments/assets/7e4d417a-7744-4018-be86-82ef28e73a5e)

### 📌 **Descripción de la Interfaz**

1. **Encabezado con Roles**:
    - Dos pestañas en la parte superior para seleccionar el rol de usuario:
      - **Administrador**.
      - **Cajero**.
    - Esto permite elegir el tipo de usuario para acceder al sistema con permisos específicos.

2. **Campos de Inicio de Sesión**:
    - **Correo Electrónico**: Un campo de texto para introducir el correo electrónico del usuario.
    - **Contraseña**: Un campo de texto para introducir la contraseña del usuario.

3. **Botón de Ingreso**:
    - Un botón con un icono de usuario y el texto **"Ingresar"**.
    - Al hacer clic en este botón, se valida la información ingresada y se permite el acceso al sistema.

### 🧩 **Funcionalidad del Código**

La funcionalidad de esta pantalla está diseñada para validar los datos del usuario e iniciar sesión según su rol seleccionado.


## Interfaz de Inicio de Sesión para Tienda de Discos

Esta imagen representa la interfaz de inicio de sesión del sistema para la tienda de discos.

---

### Descripción Visual del inicio de sesión del rol cajero
![Rol cajero]
(https://photos.app.goo.gl/uCtqhGu4pT2eF7a87)

- **Pestañas Superiores**:
  - **Administrador**: Permite seleccionar el modo de inicio de sesión para administradores.
  - **Cajero**: Permite seleccionar el modo de inicio de sesión para cajeros

- **Campos de Entrada**:
  - **Correo Electrónico**:  
    Un campo de texto para ingresar el correo electrónico del usuario.
  - **Contraseña**:  
    Un campo de texto para ingresar la contraseña del usuario.

- **Botón de Ingreso**:  
  - Botón con un icono de una persona y una flecha, etiquetado como **"Ingresar"**. Al hacer clic en este botón, el sistema valida las credenciales introducidas y permite el acceso correspondiente.

---


## Interfaz de Gestión de Ventas para Tienda de Discos

Esta sección de la aplicación corresponde a la **gestión de ventas** en la tienda de discos. La interfaz permite realizar nuevas ventas, gestionar clientes, proveedores, productos, y generar facturas en formato PDF. 

---

### Descripción Visual
![Cajero]
![image](https://github.com/user-attachments/assets/86c9ac33-e0be-4025-b3e8-16f666db784f)


---

### Componentes de la Interfaz

1. **Encabezado**:
   - **Información de Contacto**:
     - **Teléfono**: `9515323334`
     - **Mensaje de Información**:  
       "Para dudas o información puede comunicarse al número 9512044541."
     - **Ubicación**: Oaxaca, México.

2. **Formulario de Venta**:
   - **Campos**:
     - **Código**: `lp006` – Código del disco.
     - **Descripción**: `Hotel California` – Título del disco.
     - **Cantidad**: `3` – Número de unidades seleccionadas.
     - **Precio**: `30.0` – Precio unitario del disco.
     - **Stock Disponible**: `9` – Cantidad disponible en inventario.

   - **Botón "Eliminar"**:  
     Un botón con un icono de carrito y la etiqueta **"Eliminar"** para quitar el producto seleccionado de la venta.

3. **Tabla de Productos en la Venta**:
   - **Columnas**:
     - **Código**: Identificador del producto (`lp007`, `lp023`).
     - **Descripción**: Título del disco (`Thriller`, `this is it`).
     - **Cantidad**: Número de unidades (`4`, `10`).
     - **Precio**: Precio unitario (`50.0`, `40.0`).
     - **Total**: Total por producto (`200.0`, `400.0`).

4. **Sección del Cliente**:
   - **RFC**: `123456789` – Registro Federal de Contribuyentes del cliente.
   - **Nombre**: `Juan Pérez` – Nombre del cliente.
   - **Etiqueta "Administrador"**: Indica el rol del usuario actual.

5. **Opciones de Facturación**:
   - **Campo "Enviar Factura al Correo"**:  
     Permite ingresar un correo electrónico para enviar la factura.
   
   - **Total a Pagar**:  
     Muestra el total de la venta: `600.00`.

   - **Botones**:
     - **Enviar Correo**:  
       Botón para enviar la factura por correo electrónico.
     - **Pagar y Generar PDF**:  
       Botón para registrar el pago y generar una factura en formato PDF.

6. **Menú Lateral Derecho**:
   - **Botones de Acción**:
     - **Nueva Venta**: Icono de carrito – Permite iniciar una nueva venta.
     - **Clientes**: Icono de personas – Acceso al módulo de clientes.
     - **Proveedor**: Icono de archivo – Acceso al módulo de proveedores.
     - **Productos**: Icono de disco – Acceso al módulo de productos.
     - **Ventas**: Icono de dólar – Acceso al historial de ventas.

## Interfaz de Gestión de Clientes

Esta sección de la aplicación corresponde a la **gestión de clientes** en la tienda de discos. Permite agregar, editar y eliminar clientes, así como visualizar la lista de clientes almacenados en la base de datos.

---

### Descripción Visual

![Administración de los clientes
![image](https://github.com/user-attachments/assets/80414021-507f-4372-8259-811da0c270ae)

---

### Componentes de la Interfaz

1. **Formulario de Cliente**:
   - **Campos de Entrada**:
     - **RFC**: Campo para ingresar el Registro Federal de Contribuyentes del cliente.
     - **Nombre**: Campo para ingresar el nombre del cliente.
     - **Teléfono**: Campo para ingresar el número telefónico del cliente.
     - **Dirección**: Campo para ingresar la dirección del cliente.

2. **Botones de Acción**:
   - **Guardar Cliente**:  
     Permite guardar un nuevo cliente en la base de datos.
   
   - **Eliminar Cliente**:  
     Elimina el cliente seleccionado de la tabla.

   - **Editar Cliente**:  
   Permite editar los datos del cliente seleccionado.

   - **Nuevo Cliente**:  
     Limpia los campos para registrar un nuevo cliente.

3. **Tabla de Clientes**:
   - **Descripción de las Columnas**:
     - **RFC**: Identificación del cliente.
     - **Nombre**: Nombre completo del cliente.
     - **Teléfono**: Número telefónico del cliente.
     - **Dirección**: Dirección del cliente.
     - **ID**: Identificador único del cliente en la base de datos.

4. **Menú Lateral Derecho**:
   - **Botones de Navegación**:
     - **Nueva Venta**: Accede al módulo de ventas.
     - **Clientes**: Accede al módulo de gestión de clientes (actualmente activo).
     - **Proveedor**: Accede al módulo de proveedores.
     - **Productos**: Accede al módulo de gestión de productos.
     - **Ventas**: Accede al historial de ventas.

---
## Interfaz de Gestión de Proveedores

La interfaz de gestión de proveedores permite administrar los datos de proveedores en la tienda de discos . Esta sección facilita el registro, actualización y eliminación de proveedores, así como la consulta de los datos almacenados en la base de datos.

---

### Descripción Visual

![Proveedores
![image](https://github.com/user-attachments/assets/a12e74b9-7394-48e3-8c59-b91e8d2405b3)
---

### Componentes de la Interfaz

1. **Formulario de Entrada**:
   - **RFC**: Campo para ingresar el Registro Federal de Contribuyentes del proveedor.
   - **Nombre**: Campo para ingresar el nombre del proveedor.
   - **Teléfono**: Campo para ingresar el número telefónico del proveedor.
   - **Dirección**: Campo para ingresar la dirección del proveedor.

2. **Botones de Acción**:
   - **Guardar**: Guarda los datos del proveedor en la base de datos.
   - **Editar**: Permite modificar los datos del proveedor seleccionado.
   - **Eliminar**: Elimina el proveedor seleccionado de la base de datos.
   - **Agregar**: Limpia los campos del formulario para ingresar un nuevo proveedor.

3. **Tabla de Proveedores**:
   - Muestra una lista de proveedores con los siguientes campos:
     - **RFC**: Registro Federal de Contribuyentes del proveedor.
     - **Nombre**: Nombre del proveedor.
     - **Teléfono**: Número telefónico del proveedor.
     - **Dirección**: Dirección del proveedor.
     - **ID**: Identificador único del proveedor.

   La tabla permite visualizar los proveedores almacenados en la base de datos y facilita su selección para realizar operaciones de edición o eliminación.

4. **Menú Lateral Derecho**:
   - **Botones de Navegación**:
     - **Nueva Venta**: Accede al módulo de ventas para realizar nuevas transacciones.
     - **Clientes**: Accede al módulo de gestión de clientes.
     - **Proveedor**: Accede al módulo de gestión de proveedores (actualmente activo).
     - **Productos**: Accede al módulo de gestión de productos.
     - **Ventas**: Accede al historial de ventas.

---

### Funcionalidad

- **Agregar Proveedor**:  
  Permite registrar nuevos proveedores en el sistema al llenar los campos del formulario y presionar el botón **Guardar**.

- **Editar Proveedor**:  
  Permite modificar la información de un proveedor existente seleccionándolo en la tabla, cargando sus datos en el formulario y presionando el botón **Editar**.

- **Eliminar Proveedor**:  
  Elimina un proveedor seleccionado de la tabla y de la base de datos al presionar el botón **Eliminar**.

- **Consultar Proveedores**:  
  La tabla se actualiza automáticamente al realizar operaciones de agregar, editar o eliminar proveedores, mostrando siempre la información más reciente almacenada en la base de datos.

---

### Notas

- **Validaciones**:  
  Se recomienda implementar validaciones para asegurar que los campos obligatorios se completen y que los datos ingresados sigan el formato adecuado.

- **Interfaz Amigable**:  
  La disposición de los botones y formularios está diseñada para facilitar una navegación intuitiva y eficiente.


----------

## 📝 **Notas Adicionales**

-   **Manejo de Excepciones**: Se implementa validación para evitar errores en campos de texto como RFC, nombres, y precios.
-   **Seguridad**: Se recomienda no almacenar contraseñas en texto plano en el código fuente.
-   **Envío de Correos**: Si el sistema incluye envío de correos electrónicos, asegúrate de no exponer claves API en el repositorio.

----------
## Interfaz de Gestión de Productos

La interfaz de gestión de productos facilita la administración del inventario de discos en la tienda . Permite realizar operaciones de registro, actualización y eliminación de productos, así como consultar los datos almacenados en la base de datos.

---

### Descripción Visual

![Productos]
(https://photos.app.goo.gl/yx7396Q3Zo4kBosT7)

---

### Componentes de la Interfaz

1. **Formulario de Entrada**:
   - **Código**: Campo para ingresar el código único del producto.
   - **Nombre**: Campo para ingresar el nombre del disco.
   - **Stock**: Campo para ingresar la cantidad disponible del producto.
   - **Precio**: Campo para ingresar el precio del disco.
   - **Proveedor**: Menú desplegable para seleccionar el proveedor asociado al producto.

2. **Botones de Acción**:
   - **Guardar**: Guarda los datos del producto en la base de datos.
   - **Editar**: Permite modificar los datos del producto seleccionado.
   - **Eliminar Producto**: Elimina el producto seleccionado de la base de datos.
   - **Nuevo Producto**: Limpia los campos del formulario para ingresar un nuevo producto.

3. **Tabla de Productos**:
   - Muestra una lista de los productos almacenados en la base de datos con los siguientes campos:
     - **Código**: Código único que identifica el producto.
     - **Nombre**: Nombre del disco.
     - **Stock**: Cantidad de unidades disponibles en el inventario.
     - **Precio**: Precio del producto.
     - **Proveedor**: Nombre del proveedor asociado al producto.
     - **ID**: Identificador único del producto en la base de datos.

   La tabla permite visualizar los productos y facilita su selección para realizar operaciones de edición o eliminación.

4. **Menú Lateral Derecho**:
   - **Botones de Navegación**:
     - **Nueva Venta**: Accede al módulo para realizar nuevas ventas.
     - **Clientes**: Accede al módulo de gestión de clientes.
     - **Proveedor**: Accede al módulo de gestión de proveedores.
     - **Productos**: Accede al módulo actual de gestión de productos.
     - **Ventas**: Accede al historial de ventas.

---

### Funcionalidad

- **Agregar Producto**:  
  Permite registrar nuevos productos en el sistema rellenando los campos del formulario y presionando el botón **Guardar**.

- **Editar Producto**:  
  Permite modificar los datos de un producto existente seleccionándolo en la tabla, cargando sus datos en el formulario y presionando el botón **Editar**.

- **Eliminar Producto**:  
  Elimina un producto seleccionado de la tabla y de la base de datos al presionar el botón **Eliminar Producto**.

- **Consultar Productos**:  
  La tabla se actualiza automáticamente al realizar operaciones de agregar, editar o eliminar productos, mostrando siempre la información más reciente almacenada en la base de datos.

- **Navegación Rápida**:  
  Utiliza los botones del menú lateral derecho para acceder rápidamente a otros módulos del sistema.

---

### Notas

- **Validaciones**:  
  Se recomienda implementar validaciones en los campos del formulario para asegurar que se ingresen datos correctos, como números enteros en el campo **Stock** y valores decimales en el campo **Precio**.

- **Interfaz Amigable**:  
  La disposición clara y ordenada de los componentes facilita la navegación y el uso eficiente de la interfaz por parte del usuario.

---
## Interfaz de Gestión de Ventas

La interfaz de gestión de ventas facilita el seguimiento y control de las transacciones realizadas en la tienda. Permite consultar los detalles de las ventas registradas en la base de datos, mostrando información relevante para una gestión eficiente.

---

### Descripción Visual

![Historial de las ventas
![image](https://github.com/user-attachments/assets/821e3ae7-174b-49f7-a007-072286ff6589)

---

### Componentes de la Interfaz

1. **Encabezado Informativo**:
   - Información de contacto de la tienda:
     - **Nombre**: GASEDY FAIR RECORDS.
     - **Teléfono**: Número de contacto para consultas.
     - **Ubicación**: Oaxaca, México.
     - **Mensaje de Ayuda**: Sección con indicación para dudas o información adicional.

2. **Tabla de Ventas**:
   - Muestra una lista de todas las ventas registradas en la base de datos. Cada fila de la tabla representa una venta específica con los siguientes campos:
     - **ID**: Identificador único de la venta.
     - **Cliente**: Nombre del cliente que realizó la compra.
     - **Vendedor**: Nombre del vendedor que registró la venta.
     - **Total**: Monto total de la venta.

3. **Menú Lateral Derecho**:
   - **Botones de Navegación** para acceder a otros módulos del sistema:
     - **Nueva Venta**: Accede al módulo para registrar una nueva venta.
     - **Clientes**: Accede al módulo de gestión de clientes.
     - **Proveedor**: Accede al módulo de gestión de proveedores.
     - **Productos**: Accede al módulo de gestión de productos.
     - **Ventas**: Accede al módulo actual de gestión de ventas.

---

### Funcionalidad

- **Consulta de Ventas**:  
  La tabla permite visualizar el historial de ventas con detalles de cada transacción. Facilita el seguimiento de las compras realizadas por cada cliente y el desempeño de los vendedores.

- **Gestión de Transacciones**:  
  La información detallada en la tabla permite revisar los montos totales de cada venta, ayudando en tareas de auditoría y análisis de ventas.

- **Navegación Rápida**:  
  Utiliza los botones del menú lateral para acceder a otros módulos del sistema sin necesidad de cerrar la interfaz actual.

---

### Notas

- **Actualización Automática**:  
  La tabla se actualiza automáticamente después de registrar una nueva venta, asegurando que siempre se muestre la información más reciente.

- **Interfaz Intuitiva**:  
  El diseño limpio y estructurado permite al usuario localizar rápidamente la información necesaria y facilita el manejo de la interfaz.

---
## Descripción del PDF de Factura Generada al Pagar

Este PDF es generado automáticamente por el sistema de gestión de ventas de **GAISEY RECORD FAIR** después de completar una compra. Sirve como comprobante de venta para el cliente y facilita el seguimiento de transacciones.

---

### Ejemplo Visual del PDF Generado

![PDF
![image](https://github.com/user-attachments/assets/48794c46-8b26-40d2-be41-765b6ab85586)

---

### Componentes del PDF

1. **Encabezado**:
   - **Nombre de la tienda**:  
     - **GASEY RECORD FAIR**
   - **Teléfono de contacto**:  
     - Número de teléfono para consultas y soporte.
   - **Dirección**:  
     - Ubicación de la tienda en **Oaxaca, México**.
   - **Descripción del negocio**:  
     - Se indica que es una distribuidora de discos.

2. **Datos del Cliente**:  
   Sección reservada para capturar los datos del cliente que realiza la compra:
   - **RFC**: Registro Federal de Contribuyentes del cliente.
   - **Nombre**: Nombre completo del cliente.
   - **Dirección**: Dirección del cliente.

3. **Tabla de Productos Comprados**:  
   La tabla muestra un desglose detallado de los productos adquiridos:
   - **Código**: Identificador único del producto.
   - **Descripción**: Nombre del producto (por ejemplo, el título del álbum).
   - **Cantidad**: Número de unidades compradas.
   - **Precio Unitario (Precio U.)**: Costo de una unidad del producto.
   - **Precio Total (Precio T.)**: Resultado de multiplicar la cantidad por el precio unitario.

4. **Resumen de Pago**:  
   - **Total a Pagar**:  
     - Muestra el monto total que debe pagar el cliente por la compra realizada.  
     - Ejemplo: `Total a Pagar: 200.00`.

5. **Sección de Firma**:  
   - **Cancelación y Firma**:  
     Espacio para que el cliente o el encargado de la venta firme como confirmación de la transacción.

---

### Funcionalidad del PDF

- **Generación Automática**:  
  Se genera automáticamente al momento de realizar una venta y completar el pago en el sistema.

- **Propósito**:  
  - Sirve como comprobante para el cliente.  
  - Permite llevar un registro digital de las ventas realizadas.

- **Formato Estandarizado**:  
  La estructura del PDF facilita su lectura rápida y clara, con detalles organizados en secciones bien definidas.

- **Entrega Digital**:  
  Puede enviarse automáticamente al correo electrónico del cliente mediante la función de envío de correos integrados en el sistema.

---

### Notas

- **Cumplimiento Fiscal**:  
  El diseño del PDF incluye los campos necesarios para cumplir con los requisitos fiscales y proporcionar información detallada para fines de facturación.

- **Personalización**:  
  La información del cliente se rellena automáticamente desde la base de datos para asegurar precisión y evitar errores manuales.

---
## 💻 **Tecnologías Utilizadas**
## **Resumen de Clases y Responsabilidades**

### **1. `Conexion`**
- **Responsabilidad**: Manejar la conexión con la base de datos XAMPP.

### **2. `Cliente`**
- **Atributos**: `id`, `rfc`, `nombre`, `telefono`, `direccion`.
- **Métodos**: Getters y setters para manejar los datos del cliente.

### **3. `Proveedor`**
- **Atributos**: `id`, `rfc`, `nombre`, `telefono`, `direccion`.
- **Métodos**: Getters y setters para manejar los datos del proveedor.

### **4. `Producto`**
- **Atributos**: `id`, `codigo`, `nombre`, `stock`, `precio`.
- **Métodos**: Getters y setters para manejar los datos del producto.

### **5. `Venta`**
- **Atributos**: `id`, `id_cliente`, `fecha`, `total`.
- **Métodos**: Registrar ventas, eliminar ventas y actualizar el stock.

### **6. `Login`**
- **Responsabilidad**: Validar el inicio de sesión para administradores y cajeros.

---

## **Tecnologías Utilizadas**

- **Lenguaje de Programación**: Java
- **Entorno de Desarrollo**: NetBeans
- **Base de Datos**: MySQL XAMPP
- **Bibliotecas**:
  - `javax.swing` para la interfaz gráfica.
  - `java.sql` para la conexión y manejo de la base de datos.

---

---

## **Notas Finales**

Este sistema permite una administración eficiente de una tienda de discos, cubriendo desde la gestión de inventario hasta la realización de ventas y el control de clientes y proveedores. El código está modularizado para facilitar futuras ampliaciones y mantenimiento del proyecto.

