package com.fengling.shopping.product.vo;

import java.util.List;

public class CateLog2Vo {
    private String catalog1Id;
    private List<CateLog3Vo> catalog3List;
    private String id;
    private String name;

    @Override
    public String toString() {
        return "CateLog2Vo{" +
                "catalog1Id='" + catalog1Id + '\'' +
                ", catalog3List=" + catalog3List +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public CateLog2Vo(String catalog1Id, List<CateLog3Vo> catalog3List, String id, String name) {
        this.catalog1Id = catalog1Id;
        this.catalog3List = catalog3List;
        this.id = id;
        this.name = name;
    }

    public CateLog2Vo() {
    }

    public String getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(String catalog1Id) {
        this.catalog1Id = catalog1Id;
    }

    public List<CateLog3Vo> getCatalog3List() {
        return catalog3List;
    }

    public void setCatalog3List(List<CateLog3Vo> catalog3List) {
        this.catalog3List = catalog3List;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static class CateLog3Vo{
        private String catalog2Id;
        private String id;
        private String name;

        public String getCatalog2Id() {
            return catalog2Id;
        }

        public void setCatalog2Id(String catalog2Id) {
            this.catalog2Id = catalog2Id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CateLog3Vo() {
        }

        public CateLog3Vo(String catalog2Id, String id, String name) {
            this.catalog2Id = catalog2Id;
            this.id = id;
            this.name = name;
        }
    }
}
