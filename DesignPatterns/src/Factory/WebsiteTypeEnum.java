package Factory;

public enum  WebsiteTypeEnum {

    BLOG {
        @Override
        public String toString() {
            return "Blog";
        }
    },
    SHOP {
        @Override
        public String toString() {
            return "Shop";
        }
    };

    public abstract String toString();

}
