package com.mobile.healthcheck.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Object {

    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("health")
        @Expose
        private ArrayList<Object.Data.Health> health = new ArrayList<>();

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<Health> getHealth() {
            return health;
        }

        public void setHealth(ArrayList<Health> health) {
            this.health = health;
        }

        public class Health{
            @SerializedName("name")
            @Expose
            private String name;

            @SerializedName("accessible")
            @Expose
            private ArrayList<Object.Data.Health.accessible> accessible = new ArrayList<>();

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ArrayList<Health.accessible> getAccessible() {
                return accessible;
            }

            public void setAccessible(ArrayList<Health.accessible> accessible) {
                this.accessible = accessible;
            }

            public class accessible {
                @SerializedName("type")
                @Expose
                private String type;

                @SerializedName("success")
                @Expose
                private String success;

                @SerializedName("message")
                @Expose
                private String message;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSuccess() {
                    return success;
                }

                public void setSuccess(String success) {
                    this.success = success;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }
            }
        }


    }
}


