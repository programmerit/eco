/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.ecopharma.emp.service.base;

import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class DocumentLocalServiceClpInvoker {
	public DocumentLocalServiceClpInvoker() {
		_methodName0 = "addDocument";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName1 = "createDocument";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteDocument";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteDocument";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchDocument";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getDocument";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getDocuments";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getDocumentsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateDocument";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName180 = "getBeanIdentifier";

		_methodParameterTypes180 = new String[] {  };

		_methodName181 = "setBeanIdentifier";

		_methodParameterTypes181 = new String[] { "java.lang.String" };

		_methodName186 = "findAll";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "findAll";

		_methodParameterTypes187 = new String[] { "int", "int" };

		_methodName188 = "findAll";

		_methodParameterTypes188 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName189 = "findByClassNameAndClassPK";

		_methodParameterTypes189 = new String[] { "java.lang.String", "long" };

		_methodName190 = "findByClassNameClassPKAndType";

		_methodParameterTypes190 = new String[] {
				"java.lang.String", "long", "java.lang.String"
			};

		_methodName191 = "findByFileEntry";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName192 = "fetchByClassNameClassPKAndFileEntry";

		_methodParameterTypes192 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName193 = "createPrePersistedEntity";

		_methodParameterTypes193 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName194 = "addDocument";

		_methodParameterTypes194 = new String[] {
				"vn.com.ecopharma.emp.model.Document", "java.lang.String",
				"long", "long", "java.lang.String"
			};

		_methodName195 = "addDocument";

		_methodParameterTypes195 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName196 = "completelyDeleteDocuments";

		_methodParameterTypes196 = new String[] { "long" };

		_methodName197 = "uploadAndLinkEntity";

		_methodParameterTypes197 = new String[] {
				"com.liferay.portal.model.BaseModel",
				"javax.portlet.PortletRequest", "java.io.InputStream",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName198 = "getDLFileEntry";

		_methodParameterTypes198 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName199 = "getUploadFileEntry";

		_methodParameterTypes199 = new String[] {
				"com.liferay.portlet.documentlibrary.model.DLFileEntry"
			};

		_methodName200 = "getFileEntry";

		_methodParameterTypes200 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName201 = "getFilePath";

		_methodParameterTypes201 = new String[] {
				"javax.portlet.PortletRequest",
				"com.liferay.portal.kernel.repository.model.FileEntry"
			};

		_methodName202 = "uploadFile";

		_methodParameterTypes202 = new String[] {
				"javax.portlet.PortletRequest", "java.io.InputStream",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName203 = "uploadFile";

		_methodParameterTypes203 = new String[] {
				"javax.portlet.PortletRequest", "java.io.File",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName204 = "createFolder";

		_methodParameterTypes204 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return DocumentLocalServiceUtil.addDocument((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return DocumentLocalServiceUtil.createDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return DocumentLocalServiceUtil.deleteDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return DocumentLocalServiceUtil.deleteDocument((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return DocumentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return DocumentLocalServiceUtil.fetchDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return DocumentLocalServiceUtil.getDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return DocumentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return DocumentLocalServiceUtil.getDocuments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return DocumentLocalServiceUtil.getDocumentsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return DocumentLocalServiceUtil.updateDocument((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return DocumentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			DocumentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return DocumentLocalServiceUtil.findByClassNameAndClassPK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return DocumentLocalServiceUtil.findByClassNameClassPKAndType((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return DocumentLocalServiceUtil.findByFileEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return DocumentLocalServiceUtil.fetchByClassNameClassPKAndFileEntry((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return DocumentLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return DocumentLocalServiceUtil.addDocument((vn.com.ecopharma.emp.model.Document)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return DocumentLocalServiceUtil.addDocument((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			DocumentLocalServiceUtil.completelyDeleteDocuments(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadAndLinkEntity((com.liferay.portal.model.BaseModel<?>)arguments[0],
				(javax.portlet.PortletRequest)arguments[1],
				(java.io.InputStream)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return DocumentLocalServiceUtil.getDLFileEntry((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return DocumentLocalServiceUtil.getUploadFileEntry((com.liferay.portlet.documentlibrary.model.DLFileEntry)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return DocumentLocalServiceUtil.getFileEntry((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return DocumentLocalServiceUtil.getFilePath((javax.portlet.PortletRequest)arguments[0],
				(com.liferay.portal.kernel.repository.model.FileEntry)arguments[1]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadFile((javax.portlet.PortletRequest)arguments[0],
				(java.io.InputStream)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadFile((javax.portlet.PortletRequest)arguments[0],
				(java.io.File)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return DocumentLocalServiceUtil.createFolder((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
}