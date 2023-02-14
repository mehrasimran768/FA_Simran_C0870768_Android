package com.example.fa_simran_c0870768_android;

public class Product {


        private int PID;
        private String Name;
        private String Desc;
        private double Price;
        private double Latitude;
        private double Longitude;

        public Product() {
        }

        public Product(int PID, String name, String Desc, double Price, double Latitude, double Longitude) {
            this.PID = PID;
            this.Name = name;
            this.Desc = Desc;
            this.Price = Price;
            this.Latitude = Latitude;
            this.Longitude = Longitude;
        }

        public int getPID() {
            return PID;
        }

        public String getName() {
            return Name;
        }

        public String getDesc() {
            return Desc;
        }

        public double getPrice() {
            return Price;
        }

        public double getLatitude() {
            return Latitude;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setPID(int PID) {
            this.PID = PID;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setDesc(String Desc) {
            this.Desc = Desc;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public void setLatitude(double Latitude) {
            this.Latitude = Latitude;
        }

        public void setLongitude(double lLongitude) {
            this.Longitude = Longitude;
        }
        @Override
        public String toString() {
            return Name;
        }


    }


