package in.psk.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.psk.dtos.OrdersDto;
import in.psk.entity.Orders;
import in.psk.mapper.OrderMapper;
import in.psk.repo.OrdersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ReportsServiceImpl implements ReportsService {
	@Autowired
	private OrdersRepository orderRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OrdersDto> getOrders(String status, LocalDate startDate, LocalDate endDate) {
		// Obtain the CriteriaBuilder from the EntityManager
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// Create a CriteriaQuery for the Orders entity
		CriteriaQuery<Orders> query = cb.createQuery(Orders.class);
		// CriteriaBuilder and CriteriaQuery are used to construct dynamic queries.

		// Define the root of the query, which is the Orders entity
		Root<Orders> root = query.from(Orders.class);

		// Build predicates based on the provided parameters
		Predicate[] predicates = buildPredicates(cb, root, status, startDate, endDate);

		// Add the predicates to the query
		query.where(predicates);

		// Execute the query and retrieve the list of orders
		List<Orders> orders = entityManager.createQuery(query).getResultList();

		// Convert the list of Orders entities to OrdersDto objects using OrderMapper
		return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}

	private Predicate[] buildPredicates(CriteriaBuilder cb, Root<Orders> root, String status, LocalDate startDate,
			LocalDate endDate) {
		Predicate statusPredicate = null;
		Predicate datePredicate = null;

		// Create a predicate for filtering by order status
		if (status != null && !status.isEmpty()) {
			statusPredicate = cb.equal(root.get("orderStatus"), status);
		}

		// Create a predicate for filtering by order date range
		if (startDate != null && endDate != null) {
			datePredicate = cb.between(root.get("orderDate"), startDate, endDate);
		} else {
			if (startDate != null) {
				datePredicate = cb.greaterThanOrEqualTo(root.get("orderDate"), startDate);
			}
			if (endDate != null) {
				datePredicate = cb.lessThanOrEqualTo(root.get("orderDate"), endDate);
			}
		}

		// Combine the status and date predicates
		if (statusPredicate != null && datePredicate != null) {
			return new Predicate[] { statusPredicate, datePredicate };
		} else if (statusPredicate != null) {
			return new Predicate[] { statusPredicate };
		} else if (datePredicate != null) {
			return new Predicate[] { datePredicate };
		} else {
			return new Predicate[] {}; // Return an empty array if no predicates are provided
		}
	}
}
