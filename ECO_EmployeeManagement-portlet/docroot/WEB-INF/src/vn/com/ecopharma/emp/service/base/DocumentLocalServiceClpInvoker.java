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

		_methodName168 = "getBeanIdentifier";

		_methodParameterTypes168 = new String[] {  };

		_methodName169 = "setBeanIdentifier";

		_methodParameterTypes169 = new String[] { "java.lang.String" };

		_methodName174 = "findAll";

		_methodParameterTypes174 = new String[] {  };

		_methodName175 = "findAll";

		_methodParameterTypes175 = new String[] { "int", "int" };

		_methodName176 = "findAll";

		_methodParameterTypes176 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName177 = "findByClassNameAndClassPK";

		_methodParameterTypes177 = new String[] { "java.lang.String", "long" };

		_methodName178 = "findByClassNameClassPKAndType";

		_methodParameterTypes178 = new String[] {
				"java.lang.String", "long", "java.lang.String"
			};

		_methodName179 = "findByFileEntry";

		_methodParameterTypes179 = new String[] { "long" };

		_methodName180 = "createPrePersistedEntity";

		_methodParameterTypes180 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName181 = "addDocument";

		_methodParameterTypes181 = new String[] {
				"vn.com.ecopharma.emp.model.Document", "java.lang.String",
				"long", "long", "java.lang.String"
			};

		_methodName182 = "addDocument";

		_methodParameterTypes182 = new String[] {
				"java.lang.String", "long", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName183 = "completelyDeleteDocuments";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "uploadAndLinkEntity";

		_methodParameterTypes184 = new String[] {
				"com.liferay.portal.model.BaseModel",
				"org.primefaces.model.UploadedFile", "java.lang.String",
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName185 = "getDLFileEntry";

		_methodParameterTypes185 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName186 = "getUploadFileEntry";

		_methodParameterTypes186 = new String[] {
				"com.liferay.portlet.documentlibrary.model.DLFileEntry"
			};

		_methodName187 = "getFileEntry";

		_methodParameterTypes187 = new String[] {
				"vn.com.ecopharma.emp.model.Document"
			};

		_methodName188 = "getFilePath";

		_methodParameterTypes188 = new String[] {
				"com.liferay.portal.kernel.repository.model.FileEntry"
			};

		_methodName189 = "uploadFile";

		_methodParameterTypes189 = new String[] {
				"org.primefaces.model.UploadedFile", "java.lang.String",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName190 = "uploadFile";

		_methodParameterTypes190 = new String[] {
				"javax.portlet.PortletRequest", "java.io.File",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName191 = "createFolder";

		_methodParameterTypes191 = new String[] {
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

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return DocumentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			DocumentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll();
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return DocumentLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return DocumentLocalServiceUtil.findByClassNameAndClassPK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return DocumentLocalServiceUtil.findByClassNameClassPKAndType((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return DocumentLocalServiceUtil.findByFileEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return DocumentLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return DocumentLocalServiceUtil.addDocument((vn.com.ecopharma.emp.model.Document)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return DocumentLocalServiceUtil.addDocument((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			DocumentLocalServiceUtil.completelyDeleteDocuments(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadAndLinkEntity((com.liferay.portal.model.BaseModel<?>)arguments[0],
				(org.primefaces.model.UploadedFile)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return DocumentLocalServiceUtil.getDLFileEntry((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return DocumentLocalServiceUtil.getUploadFileEntry((com.liferay.portlet.documentlibrary.model.DLFileEntry)arguments[0]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return DocumentLocalServiceUtil.getFileEntry((vn.com.ecopharma.emp.model.Document)arguments[0]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return DocumentLocalServiceUtil.getFilePath((com.liferay.portal.kernel.repository.model.FileEntry)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadFile((org.primefaces.model.UploadedFile)arguments[0],
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return DocumentLocalServiceUtil.uploadFile((javax.portlet.PortletRequest)arguments[0],
				(java.io.File)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
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
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
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
}