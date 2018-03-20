# -*- coding: utf-8 -*-
# ζ

import json
import traceback

class ui(object):

	cmds = []

	@staticmethod
	def reset():
		ui.cmds = []

	@staticmethod
	def alert(msg):
		ui.cmds.append(r"""alert(%s)""" % json.dumps(msg))

	@staticmethod
	def func(f):
		def ff(obj, *args):
			ui.reset()
			try:
				f(obj, *(arg.encode('utf8') for arg in args))
			except:
				ui.alert(traceback.format_exc())
			return (';'.join(ui.cmds)).decode('utf8')
		return ff

class Controller(object):
	_public_methods_ = (
		'Method1',
		'Method2',
	)

	_reg_progid_ = 'MyCompany.Controller'

	_reg_clsid_ = '{d09d7f56-bf8f-4f6c-83d1-717c62565405}'

	@ui.func
	def Method1(self):
		return 'à'

	@ui.func
	def Method2(self, *args):
		ui.alert(args[0])

if __name__ == '__main__':
	import win32com.server.register
	win32com.server.register.UseCommandLine(Controller)
