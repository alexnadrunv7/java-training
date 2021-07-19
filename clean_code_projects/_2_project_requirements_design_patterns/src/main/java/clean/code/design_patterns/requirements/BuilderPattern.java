package clean.code.design_patterns.requirements;

class BuilderPattern
{
    static class Tea
    {
        private final String type;
        private final boolean sugar;
        private final String size;

        private Tea(Builder builder)
        {
            this.type = builder.type;
            this.sugar = builder.sugar;
            this.size = builder.size;
        }

        public static class Builder
        {
            private final String type;
            private boolean sugar;
            private String size;

            public Builder(String type)
            {
                this.type = type;
            }

            public Builder sugar(boolean value)
            {
                this.sugar = value;
                return this;
            }

            public Builder size(String value)
            {
                this.size = value;
                return this;
            }

            public Tea build()
            {
                return new Tea(this);
            }
        }

        @Override
        public String toString()
        {
            return String.format("Coffee [type=%s, sugar=%s, size=%s]", this.type, sugar, size);
        }
    }
}