package no.pgr301.konte;

class MeasurementDto{

    double lat;
    double lan;
    double pressure;
    double temperature;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public MeasurementDto(double lat, double lan, double pressure, double temperature) {
        this.lat = lat;
        this.lan = lan;
        this.pressure = pressure;
        this.temperature = temperature;
    }
}

