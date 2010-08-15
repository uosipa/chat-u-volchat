#include "log_appender.hpp"
#include "system.hpp"

#include <fstream>

using namespace com::uosipa::chatuvolchat;
using std::string;

boost::mutex logger_mutex;

string prepare_logger_line(const log_type& type, const string& logger_id, const string& line)
{
    string result;

    switch (type)
    {
    case INF:
        result += "INFO";
        break;
    case WRN:
        result += "WARN";
        break;
    default:
        result += "UNKNOWN";
    }

    result += "  [" + system::get_current_time() + "] ";
    result += logger_id + ": " + line;

    return result;
}

void append_to_file(const string& file_name, const string& line)
{
    std::ofstream out(file_name.c_str(), std::ios_base::app);
    out << line << std::endl;
    out.close();
}

void com::uosipa::chatuvolchat::append(const log_type& type, const string& logger_id, const string& line)
{
    string logger_line = prepare_logger_line(type, logger_id, line);

    {
        boost::mutex::scoped_lock lock(logger_mutex);
        append_to_file("sync_tpc_server.log", logger_line);
    }
}
