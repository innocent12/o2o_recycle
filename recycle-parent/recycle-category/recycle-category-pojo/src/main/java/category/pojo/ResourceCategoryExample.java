package category.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceCategoryExample{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public ResourceCategoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNull() {
            addCriterion("resourceId is null");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNotNull() {
            addCriterion("resourceId is not null");
            return (Criteria) this;
        }

        public Criteria andResourceidEqualTo(String value) {
            addCriterion("resourceId =", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotEqualTo(String value) {
            addCriterion("resourceId <>", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThan(String value) {
            addCriterion("resourceId >", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThanOrEqualTo(String value) {
            addCriterion("resourceId >=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThan(String value) {
            addCriterion("resourceId <", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThanOrEqualTo(String value) {
            addCriterion("resourceId <=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLike(String value) {
            addCriterion("resourceId like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotLike(String value) {
            addCriterion("resourceId not like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidIn(List<String> values) {
            addCriterion("resourceId in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotIn(List<String> values) {
            addCriterion("resourceId not in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidBetween(String value1, String value2) {
            addCriterion("resourceId between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotBetween(String value1, String value2) {
            addCriterion("resourceId not between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourcenameIsNull() {
            addCriterion("resourceName is null");
            return (Criteria) this;
        }

        public Criteria andResourcenameIsNotNull() {
            addCriterion("resourceName is not null");
            return (Criteria) this;
        }

        public Criteria andResourcenameEqualTo(String value) {
            addCriterion("resourceName =", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotEqualTo(String value) {
            addCriterion("resourceName <>", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameGreaterThan(String value) {
            addCriterion("resourceName >", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameGreaterThanOrEqualTo(String value) {
            addCriterion("resourceName >=", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLessThan(String value) {
            addCriterion("resourceName <", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLessThanOrEqualTo(String value) {
            addCriterion("resourceName <=", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameLike(String value) {
            addCriterion("resourceName like", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotLike(String value) {
            addCriterion("resourceName not like", value, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameIn(List<String> values) {
            addCriterion("resourceName in", values, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotIn(List<String> values) {
            addCriterion("resourceName not in", values, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameBetween(String value1, String value2) {
            addCriterion("resourceName between", value1, value2, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcenameNotBetween(String value1, String value2) {
            addCriterion("resourceName not between", value1, value2, "resourcename");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIsNull() {
            addCriterion("resourceType is null");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIsNotNull() {
            addCriterion("resourceType is not null");
            return (Criteria) this;
        }

        public Criteria andResourcetypeEqualTo(String value) {
            addCriterion("resourceType =", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotEqualTo(String value) {
            addCriterion("resourceType <>", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeGreaterThan(String value) {
            addCriterion("resourceType >", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeGreaterThanOrEqualTo(String value) {
            addCriterion("resourceType >=", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLessThan(String value) {
            addCriterion("resourceType <", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLessThanOrEqualTo(String value) {
            addCriterion("resourceType <=", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLike(String value) {
            addCriterion("resourceType like", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotLike(String value) {
            addCriterion("resourceType not like", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIn(List<String> values) {
            addCriterion("resourceType in", values, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotIn(List<String> values) {
            addCriterion("resourceType not in", values, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeBetween(String value1, String value2) {
            addCriterion("resourceType between", value1, value2, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotBetween(String value1, String value2) {
            addCriterion("resourceType not between", value1, value2, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcepriceIsNull() {
            addCriterion("resourcePrice is null");
            return (Criteria) this;
        }

        public Criteria andResourcepriceIsNotNull() {
            addCriterion("resourcePrice is not null");
            return (Criteria) this;
        }

        public Criteria andResourcepriceEqualTo(Double value) {
            addCriterion("resourcePrice =", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceNotEqualTo(Double value) {
            addCriterion("resourcePrice <>", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceGreaterThan(Double value) {
            addCriterion("resourcePrice >", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("resourcePrice >=", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceLessThan(Double value) {
            addCriterion("resourcePrice <", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceLessThanOrEqualTo(Double value) {
            addCriterion("resourcePrice <=", value, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceIn(List<Double> values) {
            addCriterion("resourcePrice in", values, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceNotIn(List<Double> values) {
            addCriterion("resourcePrice not in", values, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceBetween(Double value1, Double value2) {
            addCriterion("resourcePrice between", value1, value2, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcepriceNotBetween(Double value1, Double value2) {
            addCriterion("resourcePrice not between", value1, value2, "resourceprice");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeIsNull() {
            addCriterion("resourceDescribe is null");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeIsNotNull() {
            addCriterion("resourceDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeEqualTo(String value) {
            addCriterion("resourceDescribe =", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeNotEqualTo(String value) {
            addCriterion("resourceDescribe <>", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeGreaterThan(String value) {
            addCriterion("resourceDescribe >", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeGreaterThanOrEqualTo(String value) {
            addCriterion("resourceDescribe >=", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeLessThan(String value) {
            addCriterion("resourceDescribe <", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeLessThanOrEqualTo(String value) {
            addCriterion("resourceDescribe <=", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeLike(String value) {
            addCriterion("resourceDescribe like", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeNotLike(String value) {
            addCriterion("resourceDescribe not like", value, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeIn(List<String> values) {
            addCriterion("resourceDescribe in", values, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeNotIn(List<String> values) {
            addCriterion("resourceDescribe not in", values, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeBetween(String value1, String value2) {
            addCriterion("resourceDescribe between", value1, value2, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcedescribeNotBetween(String value1, String value2) {
            addCriterion("resourceDescribe not between", value1, value2, "resourcedescribe");
            return (Criteria) this;
        }

        public Criteria andResourcestockIsNull() {
            addCriterion("resourceStock is null");
            return (Criteria) this;
        }

        public Criteria andResourcestockIsNotNull() {
            addCriterion("resourceStock is not null");
            return (Criteria) this;
        }

        public Criteria andResourcestockEqualTo(Integer value) {
            addCriterion("resourceStock =", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockNotEqualTo(Integer value) {
            addCriterion("resourceStock <>", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockGreaterThan(Integer value) {
            addCriterion("resourceStock >", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockGreaterThanOrEqualTo(Integer value) {
            addCriterion("resourceStock >=", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockLessThan(Integer value) {
            addCriterion("resourceStock <", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockLessThanOrEqualTo(Integer value) {
            addCriterion("resourceStock <=", value, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockIn(List<Integer> values) {
            addCriterion("resourceStock in", values, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockNotIn(List<Integer> values) {
            addCriterion("resourceStock not in", values, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockBetween(Integer value1, Integer value2) {
            addCriterion("resourceStock between", value1, value2, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcestockNotBetween(Integer value1, Integer value2) {
            addCriterion("resourceStock not between", value1, value2, "resourcestock");
            return (Criteria) this;
        }

        public Criteria andResourcepictureIsNull() {
            addCriterion("resourcePicture is null");
            return (Criteria) this;
        }

        public Criteria andResourcepictureIsNotNull() {
            addCriterion("resourcePicture is not null");
            return (Criteria) this;
        }

        public Criteria andResourcepictureEqualTo(String value) {
            addCriterion("resourcePicture =", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureNotEqualTo(String value) {
            addCriterion("resourcePicture <>", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureGreaterThan(String value) {
            addCriterion("resourcePicture >", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureGreaterThanOrEqualTo(String value) {
            addCriterion("resourcePicture >=", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureLessThan(String value) {
            addCriterion("resourcePicture <", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureLessThanOrEqualTo(String value) {
            addCriterion("resourcePicture <=", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureLike(String value) {
            addCriterion("resourcePicture like", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureNotLike(String value) {
            addCriterion("resourcePicture not like", value, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureIn(List<String> values) {
            addCriterion("resourcePicture in", values, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureNotIn(List<String> values) {
            addCriterion("resourcePicture not in", values, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureBetween(String value1, String value2) {
            addCriterion("resourcePicture between", value1, value2, "resourcepicture");
            return (Criteria) this;
        }

        public Criteria andResourcepictureNotBetween(String value1, String value2) {
            addCriterion("resourcePicture not between", value1, value2, "resourcepicture");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table resource_category
     *
     * @mbg.generated do_not_delete_during_merge Thu Mar 15 10:40:36 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table resource_category
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}