
package com.google.api.ads.dfp.jaxws.v201602;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       Provides operations for creating, updating and retrieving {@link User}
 *       objects.
 *       <p>
 *       A user is assigned one of several different roles. Each {@link Role} type has
 *       a unique ID that is used to identify that role in an organization. Role types
 *       and their IDs can be retrieved by invoking {@link #getAllRoles}.
 *       </p>
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "UserServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserServiceInterface {


    /**
     * 
     *         Creates new {@link User} objects.
     *         
     *         @param users the users to create
     *         @return the created users with their IDs filled in
     *       
     * 
     * @param users
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201602.User>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "createUsers", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacecreateUsers")
    @ResponseWrapper(localName = "createUsersResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacecreateUsersResponse")
    public List<User> createUsers(
        @WebParam(name = "users", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
        List<User> users)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns the {@link Role} objects that are defined for the users of the
     *         network.
     *         
     *         @return the roles defined for the user's network
     *       
     * 
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201602.Role>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "getAllRoles", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetAllRoles")
    @ResponseWrapper(localName = "getAllRolesResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetAllRolesResponse")
    public List<Role> getAllRoles()
        throws ApiException_Exception
    ;

    /**
     * 
     *         Returns the current {@link User}.
     *         
     *         @return the current user
     *       
     * 
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201602.User
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "getCurrentUser", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetCurrentUser")
    @ResponseWrapper(localName = "getCurrentUserResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetCurrentUserResponse")
    public User getCurrentUser()
        throws ApiException_Exception
    ;

    /**
     * 
     *         Gets a {@link UserPage} of {@link User} objects that satisfy the given
     *         {@link Statement#query}. The following fields are supported for filtering:
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code email}</td>
     *         <td>{@link User#email}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code id}</td>
     *         <td>{@link User#id}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code name}</td>
     *         <td>{@link User#name}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code roleId}</td>
     *         <td>{@link User#roleId}
     *         </tr>
     *         <tr>
     *         <td>{@code rolename}</td>
     *         <td>{@link User#roleName}
     *         </tr>
     *         <tr>
     *         <td>{@code status}</td>
     *         <td>{@code ACTIVE} if {@link User#isActive} is true; {@code INACTIVE}
     *         otherwise</td>
     *         </tr>
     *         </table>
     *         
     *         @param filterStatement a Publisher Query Language statement used to filter
     *         a set of users
     *         @return the users that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201602.UserPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "getUsersByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetUsersByStatement")
    @ResponseWrapper(localName = "getUsersByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfacegetUsersByStatementResponse")
    public UserPage getUsersByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Performs actions on {@link User} objects that match the given
     *         {@link Statement#query}.
     *         
     *         @param userAction the action to perform
     *         @param filterStatement a Publisher Query Language statement used to filter
     *         a set of users
     *         @return the result of the action performed
     *       
     * 
     * @param userAction
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201602.UpdateResult
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "performUserAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfaceperformUserAction")
    @ResponseWrapper(localName = "performUserActionResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfaceperformUserActionResponse")
    public UpdateResult performUserAction(
        @WebParam(name = "userAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
        UserAction userAction,
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Updates the specified {@link User} objects.
     *         
     *         @param users the users to update
     *         @return the updated users
     *       
     * 
     * @param users
     * @return
     *     returns java.util.List<com.google.api.ads.dfp.jaxws.v201602.User>
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
    @RequestWrapper(localName = "updateUsers", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfaceupdateUsers")
    @ResponseWrapper(localName = "updateUsersResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602", className = "com.google.api.ads.dfp.jaxws.v201602.UserServiceInterfaceupdateUsersResponse")
    public List<User> updateUsers(
        @WebParam(name = "users", targetNamespace = "https://www.google.com/apis/ads/publisher/v201602")
        List<User> users)
        throws ApiException_Exception
    ;

}
