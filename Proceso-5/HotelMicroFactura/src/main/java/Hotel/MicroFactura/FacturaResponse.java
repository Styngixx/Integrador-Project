package Hotel.MicroFactura;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacturaResponse {

    // Creamos las llaves principales que contendrán los datos
    public Map<String, Object> Factura = new LinkedHashMap<>();
    public Map<String, Object> cliente = new LinkedHashMap<>();
    public Map<String, Object> alojamiento = new LinkedHashMap<>();
    public Map<String, Object> servicio = new LinkedHashMap<>();

    public FacturaResponse(Factura f) {
        // 1. Llenamos la llave Factura
        Factura.put("id", f.getId());
        Factura.put("numeroFactura", f.getNumeroFactura());
        Factura.put("fechaFactura", f.getFechaFactura());

        // 2. Llenamos la llave cliente
        cliente.put("nombreCliente", f.getNombreCliente());
        cliente.put("direccionCliente", f.getDireccionCliente());
        cliente.put("dniCliente", f.getDniCliente());

        // 3. Llenamos la llave alojamiento
        alojamiento.put("fechaInicioAlojamiento", f.getFechaInicioAlojamiento());
        alojamiento.put("fechaFinAlojamiento", f.getFechaFinAlojamiento());
        alojamiento.put("precioHabitacionDia", f.getPrecioHabitacionDia());
        alojamiento.put("totalAlojamiento", f.getTotalAlojamiento());

        // 4. Llenamos la llave servicio (consumos + importe total)
        servicio.put("consumos", f.getConsumos());
        servicio.put("importeTotalGeneral", f.getImporteTotalGeneral());
    }
}