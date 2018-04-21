package com.hackathon.kitty.gamification.util.specification;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hackathon.kitty.gamification.constant.Constants;

public class BaseSpecification<T> implements Specification<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2610485555790163631L;

	private SearchCriteria criteria;

	public BaseSpecification(final SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	public SearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("=")) {
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (root.get(criteria.getKey()).getJavaType() == String.class) {
				if (criteria.getValue().toString().contains(Constants.CHAR_SPLIT_MULTI_SELECT)) {
					// Handle multi select
					List<String> listValues = Arrays
							.asList(criteria.getValue().toString().split(Constants.CHAR_SPLIT_MULTI_SELECT));
					Expression<String> expression = root.get(criteria.getKey().toString());
					Predicate predicate = expression.in(listValues);
					return builder.and(predicate);
				} else {
					return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
				}
			} else {
				return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			}
		}

		return null;
	}

}
