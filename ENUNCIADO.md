# Gestión de Tarjetas de Débito y Crédito

En una empresa que ofrece servicios de tarjetas de débito y crédito, cada cliente tiene asignada una sola tarjeta.

Las tarjetas registran consumos con los siguientes detalles: mes, año, nombre del establecimiento y monto consumido.

Al final de cada mes, se debe calcular el consumo real total de cada tarjeta en el período, siguiendo las siguientes reglas:

- **Para Tarjetas de Débito**:  
  Se suman todos los consumos del período y se descuenta la devolución del IVA, calculada en base a un porcentaje específico.

- **Para Tarjetas de Crédito**:  
  Se suman todos los consumos del período y se añade el interés, calculado en base a un porcentaje específico.

### Funcionalidades del sistema

El sistema que desarrollarás debe incluir las siguientes funcionalidades:

- **Administrar el alta de tarjetas de crédito**:  
  Permitir la creación y registro de nuevas tarjetas de crédito.

- **Administrar el alta de tarjetas de débito**:  
  Permitir la creación y registro de nuevas tarjetas de débito.

- **Administrar el alta de consumos**:  
  Permitir el registro de los consumos realizados con las tarjetas, incluyendo los detalles mencionados.

- **Calcular el consumo real total de un período determinado**:  
  Permitir la obtención del total de consumo real para un período especificado, aplicando las reglas de cálculo correspondientes para tarjetas de débito y crédito.

Desarrolla el sistema asegurándote de que sea capaz de gestionar y calcular correctamente los consumos, proporcionando resultados precisos y útiles para los usuarios finales.

---

## Resolver

- Refactorizar el diagrama de clases basado en lo visto en clase del diseño del patrón **MVC** y **Singleton**.
- Realizar el **diagrama de secuencia** de acuerdo al diagrama especificado.
- **Calcular consumo real**
- Implementar en código el diagrama de clase refactorizado y secuencia diseñado.

---

### OBSERVACIONES:

El enunciado y diagrama de clases adjunto detalla a modo general los requerimientos necesarios para desarrollar el ejercicio, en caso de ser necesario se pueden incorporar clases, atributos y métodos que considere necesario para cumplir con las funcionalidades solicitadas.