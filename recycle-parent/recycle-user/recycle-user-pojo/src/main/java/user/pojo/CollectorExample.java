package user.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectorExample{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public CollectorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
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
     * This method corresponds to the database table collector
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
     * This method corresponds to the database table collector
     *
     * @mbg.generated Thu Mar 15 10:40:36 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collector
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
     * This class corresponds to the database table collector
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

        public Criteria andCollectoraccountIsNull() {
            addCriterion("collectorAccount is null");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountIsNotNull() {
            addCriterion("collectorAccount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountEqualTo(String value) {
            addCriterion("collectorAccount =", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountNotEqualTo(String value) {
            addCriterion("collectorAccount <>", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountGreaterThan(String value) {
            addCriterion("collectorAccount >", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountGreaterThanOrEqualTo(String value) {
            addCriterion("collectorAccount >=", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountLessThan(String value) {
            addCriterion("collectorAccount <", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountLessThanOrEqualTo(String value) {
            addCriterion("collectorAccount <=", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountLike(String value) {
            addCriterion("collectorAccount like", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountNotLike(String value) {
            addCriterion("collectorAccount not like", value, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountIn(List<String> values) {
            addCriterion("collectorAccount in", values, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountNotIn(List<String> values) {
            addCriterion("collectorAccount not in", values, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountBetween(String value1, String value2) {
            addCriterion("collectorAccount between", value1, value2, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectoraccountNotBetween(String value1, String value2) {
            addCriterion("collectorAccount not between", value1, value2, "collectoraccount");
            return (Criteria) this;
        }

        public Criteria andCollectornameIsNull() {
            addCriterion("collectorName is null");
            return (Criteria) this;
        }

        public Criteria andCollectornameIsNotNull() {
            addCriterion("collectorName is not null");
            return (Criteria) this;
        }

        public Criteria andCollectornameEqualTo(String value) {
            addCriterion("collectorName =", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameNotEqualTo(String value) {
            addCriterion("collectorName <>", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameGreaterThan(String value) {
            addCriterion("collectorName >", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameGreaterThanOrEqualTo(String value) {
            addCriterion("collectorName >=", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameLessThan(String value) {
            addCriterion("collectorName <", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameLessThanOrEqualTo(String value) {
            addCriterion("collectorName <=", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameLike(String value) {
            addCriterion("collectorName like", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameNotLike(String value) {
            addCriterion("collectorName not like", value, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameIn(List<String> values) {
            addCriterion("collectorName in", values, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameNotIn(List<String> values) {
            addCriterion("collectorName not in", values, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameBetween(String value1, String value2) {
            addCriterion("collectorName between", value1, value2, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectornameNotBetween(String value1, String value2) {
            addCriterion("collectorName not between", value1, value2, "collectorname");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneIsNull() {
            addCriterion("collectorPhone is null");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneIsNotNull() {
            addCriterion("collectorPhone is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneEqualTo(String value) {
            addCriterion("collectorPhone =", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneNotEqualTo(String value) {
            addCriterion("collectorPhone <>", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneGreaterThan(String value) {
            addCriterion("collectorPhone >", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneGreaterThanOrEqualTo(String value) {
            addCriterion("collectorPhone >=", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneLessThan(String value) {
            addCriterion("collectorPhone <", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneLessThanOrEqualTo(String value) {
            addCriterion("collectorPhone <=", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneLike(String value) {
            addCriterion("collectorPhone like", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneNotLike(String value) {
            addCriterion("collectorPhone not like", value, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneIn(List<String> values) {
            addCriterion("collectorPhone in", values, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneNotIn(List<String> values) {
            addCriterion("collectorPhone not in", values, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneBetween(String value1, String value2) {
            addCriterion("collectorPhone between", value1, value2, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectorphoneNotBetween(String value1, String value2) {
            addCriterion("collectorPhone not between", value1, value2, "collectorphone");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidIsNull() {
            addCriterion("collectorOpenid is null");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidIsNotNull() {
            addCriterion("collectorOpenid is not null");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidEqualTo(String value) {
            addCriterion("collectorOpenid =", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidNotEqualTo(String value) {
            addCriterion("collectorOpenid <>", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidGreaterThan(String value) {
            addCriterion("collectorOpenid >", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidGreaterThanOrEqualTo(String value) {
            addCriterion("collectorOpenid >=", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidLessThan(String value) {
            addCriterion("collectorOpenid <", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidLessThanOrEqualTo(String value) {
            addCriterion("collectorOpenid <=", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidLike(String value) {
            addCriterion("collectorOpenid like", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidNotLike(String value) {
            addCriterion("collectorOpenid not like", value, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidIn(List<String> values) {
            addCriterion("collectorOpenid in", values, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidNotIn(List<String> values) {
            addCriterion("collectorOpenid not in", values, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidBetween(String value1, String value2) {
            addCriterion("collectorOpenid between", value1, value2, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andCollectoropenidNotBetween(String value1, String value2) {
            addCriterion("collectorOpenid not between", value1, value2, "collectoropenid");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNull() {
            addCriterion("addressId is null");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNotNull() {
            addCriterion("addressId is not null");
            return (Criteria) this;
        }

        public Criteria andAddressidEqualTo(String value) {
            addCriterion("addressId =", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotEqualTo(String value) {
            addCriterion("addressId <>", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThan(String value) {
            addCriterion("addressId >", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThanOrEqualTo(String value) {
            addCriterion("addressId >=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThan(String value) {
            addCriterion("addressId <", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThanOrEqualTo(String value) {
            addCriterion("addressId <=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLike(String value) {
            addCriterion("addressId like", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotLike(String value) {
            addCriterion("addressId not like", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidIn(List<String> values) {
            addCriterion("addressId in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotIn(List<String> values) {
            addCriterion("addressId not in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidBetween(String value1, String value2) {
            addCriterion("addressId between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotBetween(String value1, String value2) {
            addCriterion("addressId not between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateIsNull() {
            addCriterion("collectorRegisterDate is null");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateIsNotNull() {
            addCriterion("collectorRegisterDate is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateEqualTo(Date value) {
            addCriterion("collectorRegisterDate =", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateNotEqualTo(Date value) {
            addCriterion("collectorRegisterDate <>", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateGreaterThan(Date value) {
            addCriterion("collectorRegisterDate >", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateGreaterThanOrEqualTo(Date value) {
            addCriterion("collectorRegisterDate >=", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateLessThan(Date value) {
            addCriterion("collectorRegisterDate <", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateLessThanOrEqualTo(Date value) {
            addCriterion("collectorRegisterDate <=", value, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateIn(List<Date> values) {
            addCriterion("collectorRegisterDate in", values, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateNotIn(List<Date> values) {
            addCriterion("collectorRegisterDate not in", values, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateBetween(Date value1, Date value2) {
            addCriterion("collectorRegisterDate between", value1, value2, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorregisterdateNotBetween(Date value1, Date value2) {
            addCriterion("collectorRegisterDate not between", value1, value2, "collectorregisterdate");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceIsNull() {
            addCriterion("collectorBalance is null");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceIsNotNull() {
            addCriterion("collectorBalance is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceEqualTo(Double value) {
            addCriterion("collectorBalance =", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceNotEqualTo(Double value) {
            addCriterion("collectorBalance <>", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceGreaterThan(Double value) {
            addCriterion("collectorBalance >", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("collectorBalance >=", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceLessThan(Double value) {
            addCriterion("collectorBalance <", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceLessThanOrEqualTo(Double value) {
            addCriterion("collectorBalance <=", value, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceIn(List<Double> values) {
            addCriterion("collectorBalance in", values, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceNotIn(List<Double> values) {
            addCriterion("collectorBalance not in", values, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceBetween(Double value1, Double value2) {
            addCriterion("collectorBalance between", value1, value2, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorbalanceNotBetween(Double value1, Double value2) {
            addCriterion("collectorBalance not between", value1, value2, "collectorbalance");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelIsNull() {
            addCriterion("collectorLevel is null");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelIsNotNull() {
            addCriterion("collectorLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelEqualTo(String value) {
            addCriterion("collectorLevel =", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelNotEqualTo(String value) {
            addCriterion("collectorLevel <>", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelGreaterThan(String value) {
            addCriterion("collectorLevel >", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelGreaterThanOrEqualTo(String value) {
            addCriterion("collectorLevel >=", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelLessThan(String value) {
            addCriterion("collectorLevel <", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelLessThanOrEqualTo(String value) {
            addCriterion("collectorLevel <=", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelLike(String value) {
            addCriterion("collectorLevel like", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelNotLike(String value) {
            addCriterion("collectorLevel not like", value, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelIn(List<String> values) {
            addCriterion("collectorLevel in", values, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelNotIn(List<String> values) {
            addCriterion("collectorLevel not in", values, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelBetween(String value1, String value2) {
            addCriterion("collectorLevel between", value1, value2, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorlevelNotBetween(String value1, String value2) {
            addCriterion("collectorLevel not between", value1, value2, "collectorlevel");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureIsNull() {
            addCriterion("collectorPicture is null");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureIsNotNull() {
            addCriterion("collectorPicture is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureEqualTo(String value) {
            addCriterion("collectorPicture =", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureNotEqualTo(String value) {
            addCriterion("collectorPicture <>", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureGreaterThan(String value) {
            addCriterion("collectorPicture >", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureGreaterThanOrEqualTo(String value) {
            addCriterion("collectorPicture >=", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureLessThan(String value) {
            addCriterion("collectorPicture <", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureLessThanOrEqualTo(String value) {
            addCriterion("collectorPicture <=", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureLike(String value) {
            addCriterion("collectorPicture like", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureNotLike(String value) {
            addCriterion("collectorPicture not like", value, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureIn(List<String> values) {
            addCriterion("collectorPicture in", values, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureNotIn(List<String> values) {
            addCriterion("collectorPicture not in", values, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureBetween(String value1, String value2) {
            addCriterion("collectorPicture between", value1, value2, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpictureNotBetween(String value1, String value2) {
            addCriterion("collectorPicture not between", value1, value2, "collectorpicture");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordIsNull() {
            addCriterion("collectorPassword is null");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordIsNotNull() {
            addCriterion("collectorPassword is not null");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordEqualTo(String value) {
            addCriterion("collectorPassword =", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordNotEqualTo(String value) {
            addCriterion("collectorPassword <>", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordGreaterThan(String value) {
            addCriterion("collectorPassword >", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("collectorPassword >=", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordLessThan(String value) {
            addCriterion("collectorPassword <", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordLessThanOrEqualTo(String value) {
            addCriterion("collectorPassword <=", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordLike(String value) {
            addCriterion("collectorPassword like", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordNotLike(String value) {
            addCriterion("collectorPassword not like", value, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordIn(List<String> values) {
            addCriterion("collectorPassword in", values, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordNotIn(List<String> values) {
            addCriterion("collectorPassword not in", values, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordBetween(String value1, String value2) {
            addCriterion("collectorPassword between", value1, value2, "collectorpassword");
            return (Criteria) this;
        }

        public Criteria andCollectorpasswordNotBetween(String value1, String value2) {
            addCriterion("collectorPassword not between", value1, value2, "collectorpassword");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table collector
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
     * This class corresponds to the database table collector
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