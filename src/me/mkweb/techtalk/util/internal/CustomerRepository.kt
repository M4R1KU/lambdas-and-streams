package me.mkweb.techtalk.util.internal

import me.mkweb.techtalk.util.model.Customer

/**
 * A Kotlin Object is a singleton
 * We use so that we do not have to write the same singleton code for each repository
 *
 * @author Mario Kunz
 */
object CustomerRepository : AbstractRepository<Customer>()